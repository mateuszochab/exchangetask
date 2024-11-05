package com.mateuszochab.exchangetask.infrastructure.adapter.account;

import com.mateuszochab.exchangetask.domain.account.model.Account;
import com.mateuszochab.exchangetask.domain.account.port.AccountPort;
import com.mateuszochab.exchangetask.domain.balance.exception.NoCurrencyExeption;
import com.mateuszochab.exchangetask.domain.balance.model.Currency;
import com.mateuszochab.exchangetask.domain.util.Operations;
import com.mateuszochab.exchangetask.infrastructure.common.exception.AccountAlreadyExistsException;
import com.mateuszochab.exchangetask.infrastructure.common.exception.AccountNotFoundException;
import com.mateuszochab.exchangetask.infrastructure.common.exception.NotEnoughResourcesException;
import com.mateuszochab.exchangetask.infrastructure.persistence.account.model.AccountEntity;
import com.mateuszochab.exchangetask.infrastructure.persistence.account.repository.AccountRepository;
import com.mateuszochab.exchangetask.infrastructure.persistence.balance.model.BalanceEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.mateuszochab.exchangetask.infrastructure.persistence.account.mapper.AccountEntityMapper.MAPPER;

@RequiredArgsConstructor
@Service
@Transactional
public class AccountAdapter implements AccountPort {
    private final AccountRepository accountRepository;
    private final MathContext mathContext;

    @Override
    public Account addAccount(Account account) {
        //place of improvements - reducing database calls by using e.g Bloom filter + Redis
        if (accountRepository.existsByUuid(account.getUuid()))
            throw new AccountAlreadyExistsException();

        var accountEntity = MAPPER.mapAccountToAccountEntity(account);
        accountEntity.getBalance().forEach(item -> item.setAccount(accountEntity));
        return MAPPER.mapAccountEntityToAccount(
                accountRepository.save(accountEntity));
    }

    @Override
    public Account getAccount(UUID accountId) {
        return MAPPER.mapAccountEntityToAccount(getAccountEntity(accountId));
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(MAPPER::mapAccountEntityToAccount)
                .collect(Collectors.toList());
    }

    @Override
    public Account convertAndUpdateAccount(UUID accountID, BigDecimal rate, Currency to, Currency from, BigDecimal amount)
            throws NoCurrencyExeption, NotEnoughResourcesException {

        var accountEntity = getAccountEntity(accountID);
        var accountBalanceFrom = accountEntity.getBalance().stream()
                .filter(balance -> from.equals(balance.getCurrency()))
                .findAny()
                .orElseThrow(() -> new NoCurrencyExeption(from));
        var accountBalanceTo = getOrCreateBalanceForCurrency(accountEntity, to);

        if (amount.compareTo(accountBalanceFrom.getAmount()) > 0) {
            throw new NotEnoughResourcesException();
        }

        updateBalance(accountBalanceFrom, accountBalanceTo, rate, amount, to);

        return MAPPER.mapAccountEntityToAccount(accountRepository.save(accountEntity));
    }

    private BalanceEntity getOrCreateBalanceForCurrency(AccountEntity accountEntity, Currency currency) {
        return accountEntity.getBalance().stream()
                .filter(balance -> currency.equals(balance.getCurrency()))
                .findAny()
                .orElseGet(() -> {
                    BalanceEntity newBalance = BalanceEntity.builder()
                            .amount(BigDecimal.ZERO)
                            .currency(currency)
                            .account(accountEntity)
                            .build();
                    accountEntity.getBalance().add(newBalance);
                    return newBalance;
                });
    }

    private void updateBalance(BalanceEntity balanceFrom, BalanceEntity balanceTo, BigDecimal rate, BigDecimal amount, Currency to) {
        balanceFrom.setAmount(balanceFrom.getAmount().subtract(amount));

        balanceTo.setAmount(balanceTo.getAmount()
                .add(convertAmount(amount, rate, to, mathContext)));
    }

    private BigDecimal convertAmount(BigDecimal amount, BigDecimal rate, Currency to, MathContext mathContext) {
        Operations operation = to.equals(Currency.PLN) ? Operations.MULTIPLY : Operations.DIVIDE;
        return operation.apply(amount, rate, mathContext);
    }

    private AccountEntity getAccountEntity(UUID accountId) {
        return accountRepository.findByUuid(accountId)
                .orElseThrow(() -> new AccountNotFoundException(accountId));
    }
}

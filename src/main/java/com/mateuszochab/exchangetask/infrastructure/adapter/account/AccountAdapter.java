package com.mateuszochab.exchangetask.infrastructure.adapter.account;

import com.mateuszochab.exchangetask.domain.account.model.Account;
import com.mateuszochab.exchangetask.domain.account.port.AccountPort;
import com.mateuszochab.exchangetask.infrastructure.common.exception.AccountAlreadyExistsException;
import com.mateuszochab.exchangetask.infrastructure.common.exception.AccountNotFoundException;
import com.mateuszochab.exchangetask.infrastructure.persistence.account.mapper.AccountEntityMapper;
import com.mateuszochab.exchangetask.infrastructure.persistence.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AccountAdapter implements AccountPort {
    private final AccountRepository accountRepository;

    @Override
    public Account addAccount(Account account) {
        //place of improvements - reducing database calls by using e.g Bloom filter + Redis
        if (accountRepository.existsByUuid(account.getUuid()))
            throw new AccountAlreadyExistsException();

        var accountEntity = AccountEntityMapper.MAPPER.mapAccountToAccountEntity(account);
        accountEntity.getBalance().forEach(item -> item.setAccount(accountEntity));
        return AccountEntityMapper.MAPPER.mapAccountEntityToAccount(
                accountRepository.save(accountEntity));
    }

    @Override
    public Account getAccount(UUID accountId) {
        return AccountEntityMapper.MAPPER.mapAccountEntityToAccount(
                accountRepository.findByUuid(accountId)
                        .orElseThrow(() -> new AccountNotFoundException(accountId)));
    }
}

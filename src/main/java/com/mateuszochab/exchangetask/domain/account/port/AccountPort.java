package com.mateuszochab.exchangetask.domain.account.port;

import com.mateuszochab.exchangetask.domain.account.model.Account;
import com.mateuszochab.exchangetask.domain.balance.exception.NoCurrencyExeption;
import com.mateuszochab.exchangetask.domain.balance.model.Currency;
import com.mateuszochab.exchangetask.infrastructure.common.exception.NotEnoughResourcesException;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface AccountPort {

    Account addAccount(Account account);

    Account getAccount(UUID accountId);

    List<Account> getAllAccounts();

    Account convertAndUpdateAccount(UUID accountID, BigDecimal rate, Currency to, Currency from, BigDecimal amount) throws NoCurrencyExeption, NotEnoughResourcesException;
}

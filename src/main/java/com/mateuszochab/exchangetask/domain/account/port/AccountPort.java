package com.mateuszochab.exchangetask.domain.account.port;

import com.mateuszochab.exchangetask.domain.account.model.Account;

import java.util.UUID;

public interface AccountPort {

    Account addAccount(Account account);

    Account getAccount(UUID accountId);

}

package com.mateuszochab.exchangetask.domain.account.port;

import com.mateuszochab.exchangetask.domain.account.model.Account;

public interface AccountPort {

    Account addUser(Account account);
}

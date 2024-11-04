package com.mateuszochab.exchangetask.infrastructure.common.exception;

import java.util.UUID;

public class AccountNotFoundException extends RuntimeException{

    private static final String ACCOUNT_WITH_ID_S_NOT_FOUND_MSG = "Account with id: %s, not found";

    public AccountNotFoundException(UUID uuid) {
        super(String.format(ACCOUNT_WITH_ID_S_NOT_FOUND_MSG,uuid));
    }
}

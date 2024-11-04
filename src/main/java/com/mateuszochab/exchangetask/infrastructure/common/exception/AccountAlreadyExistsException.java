package com.mateuszochab.exchangetask.infrastructure.common.exception;

public class AccountAlreadyExistsException extends RuntimeException {
    private static final String EXCEPTION_MSG = "Account Already Exists";

    public AccountAlreadyExistsException() {
        super(EXCEPTION_MSG);
    }
}

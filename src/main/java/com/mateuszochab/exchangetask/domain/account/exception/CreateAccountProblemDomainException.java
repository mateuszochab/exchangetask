package com.mateuszochab.exchangetask.domain.account.exception;

public class CreateAccountProblemDomainException extends Throwable {

    public static final String THERE_WAS_A_PROBLEM_CREATING_ACCOUNT_MSG = "There was a problem creating account";

    public CreateAccountProblemDomainException() {
        super(THERE_WAS_A_PROBLEM_CREATING_ACCOUNT_MSG);
    }
}

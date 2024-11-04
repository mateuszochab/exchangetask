package com.mateuszochab.exchangetask.domain.account.exception;

public class GetAccountProblemDomainException extends Throwable {

    public static final String THERE_WAS_A_PROBLEM_GETTING_ACCOUNT_MSG = "There was a problem getting account";

    public GetAccountProblemDomainException() {
        super(THERE_WAS_A_PROBLEM_GETTING_ACCOUNT_MSG);
    }


}

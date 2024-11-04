package com.mateuszochab.exchangetask.domain.account.usecase;

import com.mateuszochab.exchangetask.domain.account.exception.GetAccountProblemDomainException;
import com.mateuszochab.exchangetask.domain.account.model.Account;

import java.util.List;

public sealed interface GetAllAccountsUseCase permits GetAllAccountsUseCaseImpl {
    List<Account> execute() throws GetAccountProblemDomainException;

}

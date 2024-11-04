package com.mateuszochab.exchangetask.domain.account.usecase;

import com.mateuszochab.exchangetask.domain.account.exception.CreateAccountProblemDomainException;
import com.mateuszochab.exchangetask.domain.account.model.Account;

public sealed interface CreateAccountUseCase permits CreateAccountUseCaseImpl {

    Account execute(Account account) throws CreateAccountProblemDomainException;
}

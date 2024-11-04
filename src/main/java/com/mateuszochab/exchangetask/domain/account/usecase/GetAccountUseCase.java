package com.mateuszochab.exchangetask.domain.account.usecase;

import com.mateuszochab.exchangetask.domain.account.exception.GetAccountProblemDomainException;
import com.mateuszochab.exchangetask.domain.account.model.Account;

import java.util.UUID;

public sealed interface GetAccountUseCase permits GetAccountUseCaseImpl{

    Account execute(UUID accountId) throws GetAccountProblemDomainException;
}

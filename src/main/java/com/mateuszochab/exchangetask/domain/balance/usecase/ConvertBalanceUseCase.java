package com.mateuszochab.exchangetask.domain.balance.usecase;

import com.mateuszochab.exchangetask.domain.account.exception.GetAccountProblemDomainException;
import com.mateuszochab.exchangetask.domain.account.model.Account;
import com.mateuszochab.exchangetask.domain.balance.exception.NoCurrencyExeption;
import com.mateuszochab.exchangetask.domain.balance.model.Currency;
import com.mateuszochab.exchangetask.infrastructure.common.exception.NotEnoughResourcesException;

import java.math.BigDecimal;
import java.util.UUID;

public sealed interface ConvertBalanceUseCase permits ConvertBalanceUseCaseImpl {
    Account execute(UUID accountID, Currency from, Currency to, BigDecimal amount) throws GetAccountProblemDomainException, NoCurrencyExeption, NotEnoughResourcesException;
}

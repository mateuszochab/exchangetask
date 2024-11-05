package com.mateuszochab.exchangetask.domain.rate.usecase;

import com.mateuszochab.exchangetask.domain.balance.model.Currency;
import com.mateuszochab.exchangetask.domain.rate.model.Rate;

public sealed interface GetRatesUseCase permits GetRatesUseCaseImpl {
    Rate execute(Currency currency);
}

package com.mateuszochab.exchangetask.infrastructure.persistence.rate;

import com.mateuszochab.exchangetask.domain.balance.model.Currency;
import com.mateuszochab.exchangetask.domain.rate.model.Rate;

public sealed interface RateRepository permits RateRepositoryImpl {

    Rate obtainRate(Currency currency);
}

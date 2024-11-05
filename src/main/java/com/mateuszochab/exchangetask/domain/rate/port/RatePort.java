package com.mateuszochab.exchangetask.domain.rate.port;

import com.mateuszochab.exchangetask.domain.balance.model.Currency;
import com.mateuszochab.exchangetask.domain.rate.model.Rate;

public interface RatePort {

    Rate getRate(Currency currency);
}

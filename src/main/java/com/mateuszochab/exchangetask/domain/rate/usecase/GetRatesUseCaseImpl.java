package com.mateuszochab.exchangetask.domain.rate.usecase;

import com.mateuszochab.exchangetask.domain.balance.model.Currency;
import com.mateuszochab.exchangetask.domain.rate.model.Rate;
import com.mateuszochab.exchangetask.domain.rate.port.RatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public non-sealed class GetRatesUseCaseImpl implements GetRatesUseCase {

    private final RatePort ratePort;

    @Override
    public Rate execute(Currency currency) {
        return ratePort.getRate(currency);
    }
}

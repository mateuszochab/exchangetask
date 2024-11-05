package com.mateuszochab.exchangetask.infrastructure.adapter.rate;

import com.mateuszochab.exchangetask.domain.balance.model.Currency;
import com.mateuszochab.exchangetask.domain.rate.model.Rate;
import com.mateuszochab.exchangetask.domain.rate.port.RatePort;
import com.mateuszochab.exchangetask.infrastructure.persistence.rate.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RateAdapter implements RatePort {
    private final RateRepository rateRepository;

    @Override
    public Rate getRate(Currency currency) {
        return rateRepository.obtainRate(currency);
    }
}

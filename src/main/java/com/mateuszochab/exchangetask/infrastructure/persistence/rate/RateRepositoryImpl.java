package com.mateuszochab.exchangetask.infrastructure.persistence.rate;

import com.mateuszochab.exchangetask.domain.balance.model.Currency;
import com.mateuszochab.exchangetask.domain.rate.model.Rate;
import com.mateuszochab.exchangetask.infrastructure.persistence.rate.model.RateDetailsDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Locale;

@Service
public non-sealed class RateRepositoryImpl implements RateRepository {
    private final RestClient restClient;

    private String apiBaseUrl = "https://api.nbp.pl/api/exchangerates/rates/a/";

    public RateRepositoryImpl() {
        this.restClient = RestClient.builder()
                .baseUrl(apiBaseUrl)
                .build();
    }

    @Override
    public Rate obtainRate(Currency currency) {
        var response = restClient.get()
                .uri(currency.toString().toLowerCase(Locale.ROOT))
                .retrieve()
                .body(RateDetailsDto.class);
        return Rate.builder()
                .rate(response.rates().getFirst().mid())
                .build();
    }
}

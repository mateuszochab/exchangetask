package com.mateuszochab.exchangetask.infrastructure.persistence.rate.model;

import java.util.List;

public record RateDetailsDto(
        String table,
        String currency,
        String code,
        List<RateDto> rates
) { }

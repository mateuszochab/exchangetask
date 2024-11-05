package com.mateuszochab.exchangetask.domain.rate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Rate model class
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class Rate {
    private BigDecimal rate;
}

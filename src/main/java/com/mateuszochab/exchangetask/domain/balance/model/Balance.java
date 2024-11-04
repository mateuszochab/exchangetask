package com.mateuszochab.exchangetask.domain.balance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Balance model classss
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Balance {
    private Currency currency;
    private BigDecimal amount;
}

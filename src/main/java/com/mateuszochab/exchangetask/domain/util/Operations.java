package com.mateuszochab.exchangetask.domain.util;

import com.mateuszochab.exchangetask.domain.util.functinterface.TriFunction;

import java.math.BigDecimal;
import java.math.MathContext;

public enum Operations {
    MULTIPLY((amount, rate, mathContext) -> amount.multiply(rate, mathContext)),
    DIVIDE((amount, rate, mathContext) -> amount.divide(rate, mathContext));

    private final TriFunction<BigDecimal, BigDecimal, MathContext, BigDecimal> operation;

    Operations(TriFunction<BigDecimal, BigDecimal, MathContext, BigDecimal> operation) {
        this.operation = operation;
    }

    public BigDecimal apply(BigDecimal amount, BigDecimal rate, MathContext mathContext) {
        return operation.apply(amount, rate, mathContext);
    }
}

package com.mateuszochab.exchangetask.domain.balance.exception;

import com.mateuszochab.exchangetask.domain.balance.model.Currency;

public class NoCurrencyExeption extends Throwable {

    public static final String YOU_DON_T_HAVE_ANY_S_FOR_EXCHANGE_MSG = "You don't have any %s for exchange";

    public NoCurrencyExeption(Currency from) {
        super(String.format(YOU_DON_T_HAVE_ANY_S_FOR_EXCHANGE_MSG, from));
    }
}

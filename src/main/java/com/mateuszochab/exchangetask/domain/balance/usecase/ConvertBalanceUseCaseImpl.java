package com.mateuszochab.exchangetask.domain.balance.usecase;

import com.mateuszochab.exchangetask.domain.account.exception.GetAccountProblemDomainException;
import com.mateuszochab.exchangetask.domain.account.model.Account;
import com.mateuszochab.exchangetask.domain.account.port.AccountPort;
import com.mateuszochab.exchangetask.domain.balance.exception.NoCurrencyExeption;
import com.mateuszochab.exchangetask.domain.balance.model.Currency;
import com.mateuszochab.exchangetask.domain.rate.usecase.GetRatesUseCase;
import com.mateuszochab.exchangetask.infrastructure.common.exception.NotEnoughResourcesException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public non-sealed class ConvertBalanceUseCaseImpl implements ConvertBalanceUseCase {
    private final GetRatesUseCase getRatesUseCase;
    private final AccountPort accountPort;

    @Override
    public Account execute(UUID accountID, Currency from, Currency to, BigDecimal amount) throws GetAccountProblemDomainException, NoCurrencyExeption, NotEnoughResourcesException {
        var rate = to.equals(Currency.PLN) ? getRatesUseCase.execute(from) : getRatesUseCase.execute(to);
        return accountPort.convertAndUpdateAccount(accountID,rate.getRate(),to, from,amount);
    }
}

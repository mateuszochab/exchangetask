package com.mateuszochab.exchangetask.infrastructure.rest.balance.controller;

import com.mateuszochab.exchangetask.domain.account.exception.GetAccountProblemDomainException;
import com.mateuszochab.exchangetask.domain.balance.exception.NoCurrencyExeption;
import com.mateuszochab.exchangetask.domain.balance.usecase.ConvertBalanceUseCase;
import com.mateuszochab.exchangetask.infrastructure.common.exception.NotEnoughResourcesException;
import com.mateuszochab.exchangetask.infrastructure.rest.balance.dto.ConvertBalanceRequestDto;
import com.mateuszochab.exchangetask.infrastructure.rest.balance.dto.ConvertBalanceResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public non-sealed class BalanceControllerImpl implements BalanceController {
   private final ConvertBalanceUseCase convertBalanceUseCase;

    @Override
    public ConvertBalanceResponseDto convert(ConvertBalanceRequestDto convertBalanceRequestDto) throws GetAccountProblemDomainException, NoCurrencyExeption, NotEnoughResourcesException {
        var account = convertBalanceUseCase.execute(convertBalanceRequestDto.getAccountId(),
                convertBalanceRequestDto.getFrom(), convertBalanceRequestDto.getTo(), convertBalanceRequestDto.getAmount());

        return ConvertBalanceResponseDto.builder()
                .accountId(account.getUuid())
                .balance(account.getBalance())
                .build();
    }
}

package com.mateuszochab.exchangetask.infrastructure.rest.balance.controller;

import com.mateuszochab.exchangetask.domain.account.exception.GetAccountProblemDomainException;
import com.mateuszochab.exchangetask.domain.balance.exception.NoCurrencyExeption;
import com.mateuszochab.exchangetask.infrastructure.common.exception.NotEnoughResourcesException;
import com.mateuszochab.exchangetask.infrastructure.rest.balance.dto.ConvertBalanceRequestDto;
import com.mateuszochab.exchangetask.infrastructure.rest.balance.dto.ConvertBalanceResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/api/v1/balances")
public sealed interface BalanceController permits BalanceControllerImpl {
    @Operation(
            description = "Convert amount of money from one currency to another",
            summary = "Convert amount of money from one currency to another"
    )
    @PutMapping("/convert")
    ConvertBalanceResponseDto convert(@RequestBody ConvertBalanceRequestDto convertBalanceRequestDto) throws GetAccountProblemDomainException, NoCurrencyExeption, NotEnoughResourcesException;
}

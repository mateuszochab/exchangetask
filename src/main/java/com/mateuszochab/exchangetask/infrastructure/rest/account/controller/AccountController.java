package com.mateuszochab.exchangetask.infrastructure.rest.account.controller;

import com.mateuszochab.exchangetask.domain.account.exception.CreateAccountProblemDomainException;
import com.mateuszochab.exchangetask.domain.account.exception.GetAccountProblemDomainException;
import com.mateuszochab.exchangetask.infrastructure.rest.account.dto.response.CreateAccountResponseDto;
import com.mateuszochab.exchangetask.infrastructure.rest.account.dto.CreateAccountRequestDto;
import com.mateuszochab.exchangetask.infrastructure.rest.account.dto.response.GetAccountResponseDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping(path = "/api/v1/accounts")
public sealed interface AccountController permits AccountControllerImpl {


    @PostMapping
    CreateAccountResponseDto createAccount(@RequestBody @Valid CreateAccountRequestDto createAccountRequestDto) throws CreateAccountProblemDomainException;

    @GetMapping("/{accountId}")
    GetAccountResponseDto getAccount(@PathVariable UUID accountId) throws GetAccountProblemDomainException;


}

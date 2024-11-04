package com.mateuszochab.exchangetask.infrastructure.rest.account.controller;

import com.mateuszochab.exchangetask.domain.account.exception.CreateAccountProblemDomainException;
import com.mateuszochab.exchangetask.infrastructure.rest.account.dto.CreateAccountResponseDto;
import com.mateuszochab.exchangetask.infrastructure.rest.account.dto.CreateAccountRequestDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/api/v1/accounts")
public sealed interface AccountController permits AccountControllerImpl {


    @PostMapping
    CreateAccountResponseDto createAccount(@RequestBody @Valid CreateAccountRequestDto createAccountRequestDto) throws CreateAccountProblemDomainException;
}

package com.mateuszochab.exchangetask.infrastructure.rest.account.controller;

import com.mateuszochab.exchangetask.domain.account.exception.CreateAccountProblemDomainException;
import com.mateuszochab.exchangetask.domain.account.exception.GetAccountProblemDomainException;
import com.mateuszochab.exchangetask.infrastructure.rest.account.dto.response.GetAllAccountsResponseDto;
import com.mateuszochab.exchangetask.infrastructure.rest.account.dto.response.CreateAccountResponseDto;
import com.mateuszochab.exchangetask.infrastructure.rest.account.dto.CreateAccountRequestDto;
import com.mateuszochab.exchangetask.infrastructure.rest.account.dto.response.GetAccountResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping(path = "/api/v1/accounts")
public sealed interface AccountController permits AccountControllerImpl {
    @Operation(
            description = "Create new account",
            summary = "Create new account",
            responses = {
                    @ApiResponse(
                            description = "Created",
                            responseCode = "201")
            }
    )
    @PostMapping
    CreateAccountResponseDto createAccount(@RequestBody @Valid CreateAccountRequestDto createAccountRequestDto) throws CreateAccountProblemDomainException;
    @Operation(
            description = "Get Account by Id",
            summary = "Get Account by id",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200")
            }
    )
    @GetMapping("/{accountId}")
    GetAccountResponseDto getAccount(@PathVariable UUID accountId) throws GetAccountProblemDomainException;
    @Operation(
            description = "Get All Accounts",
            summary = "Get All Accounts",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200")
            }
    )
    @GetMapping("/all")
    GetAllAccountsResponseDto getAllAccounts() throws GetAccountProblemDomainException;

}

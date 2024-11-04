package com.mateuszochab.exchangetask.infrastructure.rest.account.controller;

import com.mateuszochab.exchangetask.domain.account.exception.CreateAccountProblemDomainException;
import com.mateuszochab.exchangetask.domain.account.exception.GetAccountProblemDomainException;
import com.mateuszochab.exchangetask.domain.account.usecase.CreateAccountUseCase;
import com.mateuszochab.exchangetask.domain.account.usecase.GetAccountUseCase;
import com.mateuszochab.exchangetask.domain.account.usecase.GetAllAccountsUseCase;
import com.mateuszochab.exchangetask.infrastructure.rest.account.dto.CreateAccountRequestDto;
import com.mateuszochab.exchangetask.infrastructure.rest.account.dto.response.CreateAccountResponseDto;
import com.mateuszochab.exchangetask.infrastructure.rest.account.dto.response.GetAccountResponseDto;
import com.mateuszochab.exchangetask.infrastructure.rest.account.dto.response.GetAllAccountsResponseDto;
import com.mateuszochab.exchangetask.infrastructure.rest.account.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public final class AccountControllerImpl implements AccountController {

    private final CreateAccountUseCase createAccountUseCase;
    private final GetAccountUseCase getAccountUseCase;
    private final GetAllAccountsUseCase getAllAccountsUseCase;

    @Override
    public CreateAccountResponseDto createAccount(CreateAccountRequestDto createAccountRequestDto) throws CreateAccountProblemDomainException {
        return AccountMapper.MAPPER.mapAccountToCreateAccountResponseDto(createAccountUseCase.execute(
                AccountMapper.MAPPER.mapCreateAccountRequestDtoToAccount(createAccountRequestDto)));
    }

    @Override
    public GetAccountResponseDto getAccount(UUID accountId) throws GetAccountProblemDomainException {
        return AccountMapper.MAPPER.mapAccountToGetAccountResponseDto(getAccountUseCase.execute(accountId));
    }

    @Override
    public GetAllAccountsResponseDto getAllAccounts() throws GetAccountProblemDomainException {
        return GetAllAccountsResponseDto.builder()
                .accounts(getAllAccountsUseCase.execute().stream()
                        .map(AccountMapper.MAPPER::mapAccountToGetAccountResponseDto)
                        .toList())
                .build();
    }


}

package com.mateuszochab.exchangetask.infrastructure.rest.account.controller;

import com.mateuszochab.exchangetask.domain.account.exception.CreateAccountProblemDomainException;
import com.mateuszochab.exchangetask.domain.account.usecase.CreateAccountUseCase;
import com.mateuszochab.exchangetask.infrastructure.rest.account.dto.CreateAccountRequestDto;
import com.mateuszochab.exchangetask.infrastructure.rest.account.dto.CreateAccountResponseDto;
import com.mateuszochab.exchangetask.infrastructure.rest.account.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public final class AccountControllerImpl implements AccountController {

    private final CreateAccountUseCase createAccountUseCase;

    @Override
    public CreateAccountResponseDto createAccount(CreateAccountRequestDto createAccountRequestDto) throws CreateAccountProblemDomainException {
        return AccountMapper.MAPPER.mapAccountToCreateAccountResponseDto(createAccountUseCase.execute(
                AccountMapper.MAPPER.mapCreateAccountRequestDtoToAccount(createAccountRequestDto)));
    }
}

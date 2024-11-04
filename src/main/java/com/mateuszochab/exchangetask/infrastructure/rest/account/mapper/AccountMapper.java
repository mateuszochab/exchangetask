package com.mateuszochab.exchangetask.infrastructure.rest.account.mapper;

import com.mateuszochab.exchangetask.domain.account.model.Account;
import com.mateuszochab.exchangetask.domain.balance.model.Balance;
import com.mateuszochab.exchangetask.infrastructure.rest.account.dto.BalanceRequestDto;
import com.mateuszochab.exchangetask.infrastructure.rest.account.dto.CreateAccountRequestDto;
import com.mateuszochab.exchangetask.infrastructure.rest.account.dto.response.CreateAccountResponseDto;
import com.mateuszochab.exchangetask.infrastructure.rest.account.dto.response.GetAccountResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {
    AccountMapper MAPPER = Mappers.getMapper(AccountMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Account mapCreateAccountRequestDtoToAccount(CreateAccountRequestDto createAccountRequestDto);

    @Mapping(target = "id", source = "uuid")
    CreateAccountResponseDto mapAccountToCreateAccountResponseDto(Account account);

    Balance mapBalanceRequestDtoToBalance(BalanceRequestDto balanceRequestDto);

    @Mapping(target = "id", source = "uuid")
    GetAccountResponseDto mapAccountToGetAccountResponseDto(Account account);

}

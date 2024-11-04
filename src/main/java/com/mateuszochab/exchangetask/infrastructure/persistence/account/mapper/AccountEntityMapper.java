package com.mateuszochab.exchangetask.infrastructure.persistence.account.mapper;

import com.mateuszochab.exchangetask.domain.account.model.Account;
import com.mateuszochab.exchangetask.infrastructure.persistence.account.model.AccountEntity;
import com.mateuszochab.exchangetask.infrastructure.persistence.balance.model.BalanceEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = BalanceEntityMapper.class)
public interface AccountEntityMapper {

    AccountEntityMapper MAPPER = Mappers.getMapper(AccountEntityMapper.class);

    @Mapping(target = "version", ignore = true)
    @Mapping(target = "balance")
    AccountEntity mapAccountToAccountEntity(Account account);
    Account mapAccountEntityToAccount(AccountEntity accountEntity);
}

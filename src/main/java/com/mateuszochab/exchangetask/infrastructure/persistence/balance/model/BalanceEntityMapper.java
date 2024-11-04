package com.mateuszochab.exchangetask.infrastructure.persistence.balance.model;

import com.mateuszochab.exchangetask.domain.balance.model.Balance;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BalanceEntityMapper {

    BalanceEntityMapper MAPPER = Mappers.getMapper(BalanceEntityMapper.class);

    BalanceEntity mapBalanceToBalanceEntity(Balance balance);

    Balance mapBalanceEntityToBalance(BalanceEntity balanceEntity);
}

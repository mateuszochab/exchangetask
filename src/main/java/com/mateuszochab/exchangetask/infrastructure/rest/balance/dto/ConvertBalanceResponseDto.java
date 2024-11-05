package com.mateuszochab.exchangetask.infrastructure.rest.balance.dto;


import com.mateuszochab.exchangetask.domain.balance.model.Balance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class ConvertBalanceResponseDto {
    private UUID accountId;
    private List<Balance> balance;
}

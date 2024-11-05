package com.mateuszochab.exchangetask.infrastructure.rest.balance.dto;

import com.mateuszochab.exchangetask.domain.balance.model.Currency;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class ConvertBalanceRequestDto {
    @NotBlank
    private UUID accountId;
    @NotBlank
    private Currency from;
    @NotBlank
    private Currency to;
    @NotBlank
    private BigDecimal amount;
}

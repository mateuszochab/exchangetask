package com.mateuszochab.exchangetask.infrastructure.rest.account.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Balance Request Dto
 */

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class BalanceRequestDto {
    @NotBlank(message = "Currency should be either PLN or USD")
    private String currency;
    @Min(value = 0, message = "Amount should be a positive value")
    private BigDecimal amount;
}

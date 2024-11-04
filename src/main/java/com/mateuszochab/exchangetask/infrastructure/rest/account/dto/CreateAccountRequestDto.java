package com.mateuszochab.exchangetask.infrastructure.rest.account.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreateAccountRequestDto {
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    private List<BalanceRequestDto> balance;
}

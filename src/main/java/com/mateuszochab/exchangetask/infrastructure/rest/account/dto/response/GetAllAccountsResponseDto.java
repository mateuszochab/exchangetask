package com.mateuszochab.exchangetask.infrastructure.rest.account.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class GetAllAccountsResponseDto {
    private List<GetAccountResponseDto> accounts;
}

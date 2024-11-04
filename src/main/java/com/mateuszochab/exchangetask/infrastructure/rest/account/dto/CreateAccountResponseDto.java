package com.mateuszochab.exchangetask.infrastructure.rest.account.dto;

import com.mateuszochab.exchangetask.domain.balance.model.Balance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * Create Account Response Dto
 */

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class CreateAccountResponseDto {
    private UUID id;
    private String firstname;
    private String lastname;
    private List<Balance> balance;
    private Instant createdAt;
    private Instant updatedAt;
}

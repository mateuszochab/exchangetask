package com.mateuszochab.exchangetask.infrastructure.rest.account.dto.response;

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
 * Get Account Response Dto class
 */

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class GetAccountResponseDto {
    private UUID id;
    private String firstname;
    private String lastname;
    private List<Balance> balance;
    private Instant createdAt;
    private Instant updatedAt;
}

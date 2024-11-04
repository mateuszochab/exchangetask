package com.mateuszochab.exchangetask.domain.account.model;

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
 * Balance model class
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class Account {
    private Long id;
    private UUID uuid;
    private String firstname;
    private String lastname;
    private List<Balance> balance;
    private Instant createdAt;
    private Instant updatedAt;
}

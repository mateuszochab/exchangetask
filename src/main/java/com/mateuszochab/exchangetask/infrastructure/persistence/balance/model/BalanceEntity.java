package com.mateuszochab.exchangetask.infrastructure.persistence.balance.model;

import com.mateuszochab.exchangetask.domain.balance.model.Currency;
import com.mateuszochab.exchangetask.infrastructure.persistence.account.model.AccountEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "Balance")
@Table(name = "BALANCE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BalanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    private Currency currency;
    @Column(name = "amount")
    private BigDecimal amount;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private AccountEntity account;
}

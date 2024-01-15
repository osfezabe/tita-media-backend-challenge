package com.titamedia.challenge.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DebtSummary {
    @Id
    private Integer id;
    private Long paidAmount;
    private Long pendingAmount;
    private Integer paidInstallments;
    private Integer pendingInstallments;
    @Enumerated(EnumType.STRING)
    private DebtStatus status;
}

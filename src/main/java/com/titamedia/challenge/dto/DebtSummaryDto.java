package com.titamedia.challenge.dto;

import com.titamedia.challenge.domain.DebtStatus;

public record DebtSummaryDto(Integer id,
                             Double paidAmount,
                             Double pendingAmount,
                             Integer paidInstallments,
                             Integer pendingInstallments,
                             DebtStatus status) {
}

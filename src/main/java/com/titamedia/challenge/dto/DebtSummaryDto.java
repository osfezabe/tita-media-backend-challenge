package com.titamedia.challenge.dto;

import com.titamedia.challenge.domain.DebtStatus;

public record DebtSummaryDto(Integer id,
                             Long paidAmount,
                             Long pendingAmount,
                             Integer paidInstallments,
                             Integer pendingInstallments,
                             DebtStatus status) {
}

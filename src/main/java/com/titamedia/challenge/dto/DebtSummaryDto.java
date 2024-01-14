package com.titamedia.challenge.dto;

public record DebtSummaryDto(Integer id,
                             Double paidAmount,
                             Double pendingAmount,
                             Integer paidInstallments,
                             Integer pendingInstallments) {
}

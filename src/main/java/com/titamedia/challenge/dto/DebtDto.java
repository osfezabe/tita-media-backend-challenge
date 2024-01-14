package com.titamedia.challenge.dto;

import com.titamedia.challenge.domain.DebtStatus;

import java.time.LocalDateTime;

public record DebtDto(Integer id,
                      LocalDateTime createdAt,
                      DebtStatus status,
                      Double initialAmount,
                      Integer installments) {
}

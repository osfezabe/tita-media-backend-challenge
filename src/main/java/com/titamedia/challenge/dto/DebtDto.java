package com.titamedia.challenge.dto;

import java.time.LocalDateTime;

public record DebtDto(Integer id,
                      LocalDateTime createdAt,
                      Double initialAmount,
                      Integer installments) {
}

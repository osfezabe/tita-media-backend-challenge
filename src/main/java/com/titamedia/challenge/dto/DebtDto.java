package com.titamedia.challenge.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DebtDto(Integer id,
                      @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") LocalDateTime createdAt,
                      Long initialAmount,
                      Integer installments) {
}

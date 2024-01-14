package com.titamedia.challenge.dto.request;

public record AddPaymentRequestDto(
        boolean totalPayment,
        Integer installments
) {
}

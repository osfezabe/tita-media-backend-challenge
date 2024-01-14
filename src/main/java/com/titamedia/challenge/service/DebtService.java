package com.titamedia.challenge.service;

import com.titamedia.challenge.domain.Debt;
import com.titamedia.challenge.domain.DebtStatus;
import com.titamedia.challenge.domain.Payment;
import com.titamedia.challenge.dto.DebtDto;
import com.titamedia.challenge.dto.DebtSummaryDto;
import com.titamedia.challenge.dto.request.AddPaymentRequestDto;
import com.titamedia.challenge.exceptions.BankException;
import com.titamedia.challenge.mapper.DebtMapper;
import com.titamedia.challenge.repository.DebtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DebtService {
    private final DebtRepository debtRepository;
    private final DebtMapper debtMapper;

    public List<DebtDto> findByUserIdAndBankId(Integer userId, Integer bankId) {
        var debtList = debtRepository.findByUserIdAndBankId(userId, bankId);
        return debtMapper.toDebtDto(debtList);
    }

    public DebtSummaryDto findSummary(Integer userId, Integer debtId) {
        var debt = debtRepository.findByUserIdAndId(userId, debtId).orElseThrow();
        return debtMapper.toDebtSummaryDto(debt.getSummary());
    }

    public DebtSummaryDto addPayment(Integer userId, Integer debtId, AddPaymentRequestDto request) {
        var debt = debtRepository.findByUserIdAndId(userId, debtId).orElseThrow();
        validateRequest(debt, request);
        var installments = getNumberOfInstallmentsToPay(debt, request);
        var value = getValueToPay(debt, installments);
        var payment = createPayment(debt, value, installments);

        debt.getPayments().add(payment);
        updateDebtSummary(debt, payment);

        debtRepository.save(debt);
        return debtMapper.toDebtSummaryDto(debt.getSummary());
    }

    private void updateDebtSummary(Debt debt, Payment payment) {
        var summary = debt.getSummary();
        summary.setPaidAmount(summary.getPaidAmount() + payment.getValue());
        summary.setPaidInstallments(summary.getPaidInstallments() + payment.getInstallments());

        summary.setPendingAmount(summary.getPendingAmount() - payment.getValue());
        summary.setPendingInstallments(summary.getPendingInstallments() - payment.getInstallments());

        summary.setStatus(summary.getPendingInstallments() > 0 ? DebtStatus.ACTIVE : DebtStatus.PAID);
    }

    private Payment createPayment(Debt debt, Double value, Integer installments) {
        var payment = new Payment();
        payment.setCreatedAt(LocalDateTime.now());
        payment.setDebt(debt);
        payment.setValue(value);
        payment.setInstallments(installments);
        return payment;
    }

    private void validateRequest(Debt debt, AddPaymentRequestDto request) {
        if (DebtStatus.PAID.equals(debt.getSummary().getStatus())) {
            throw new BankException("No se pueden añadir pagos porque la deuda ya se encuentra pagada.");
        }
        if (!request.totalPayment() && request.installments() > debt.getSummary().getPendingInstallments()) {
            throw new BankException("No se puede añadir el pago porque el número de cuotas indicado supera la cantidad de cuotas pendientes");
        }
    }

    private Integer getNumberOfInstallmentsToPay(Debt debt, AddPaymentRequestDto request) {
        return request.totalPayment() ? debt.getSummary().getPendingInstallments() : request.installments();
    }

    private Double getValueToPay(Debt debt, Integer installments) {
        return installments * debt.getInitialAmount() / debt.getInstallments();
    }
}

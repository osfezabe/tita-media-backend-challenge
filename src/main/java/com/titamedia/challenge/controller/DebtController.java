package com.titamedia.challenge.controller;

import com.titamedia.challenge.dto.BankDto;
import com.titamedia.challenge.dto.DebtDto;
import com.titamedia.challenge.dto.DebtSummaryDto;
import com.titamedia.challenge.dto.request.AddPaymentRequestDto;
import com.titamedia.challenge.service.BankService;
import com.titamedia.challenge.service.DebtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "v1/debts")
@RequiredArgsConstructor
@Log4j2
public class DebtController {
    private final BankService bankService;
    private final DebtService debtService;

    @GetMapping("{userId}/banks")
    public ResponseEntity<List<BankDto>> listBanks(@PathVariable Integer userId) {
        log.info("Request to get list of user's banks");
        var bankList = bankService.findByUserId(userId);
        return ResponseEntity.ok(bankList);
    }

    @GetMapping("{userId}/banks/{bankId}")
    public ResponseEntity<List<DebtDto>> listDebts(@PathVariable Integer userId, @PathVariable Integer bankId) {
        log.info("Request to get the list of debts for given user id {} and bank id {}", userId, bankId);
        var debtList = debtService.findByUserIdAndBankId(userId, bankId);
        return ResponseEntity.ok(debtList);
    }

    @GetMapping("{userId}/summary/{debtId}")
    public ResponseEntity<DebtSummaryDto> getDebtSummary(@PathVariable Integer userId, @PathVariable Integer debtId) {
        log.info("Request get the debt summary for user id {} and debt id {}", userId, debtId);
        var debtSummary = debtService.findSummary(userId, debtId);
        return ResponseEntity.ok(debtSummary);
    }

    @PostMapping("{userId}/pay/{debtId}")
    public ResponseEntity<DebtSummaryDto> addPayment(@PathVariable Integer userId, @PathVariable Integer debtId,
                                                     @RequestBody AddPaymentRequestDto addPaymentRequestDto) {
        log.info("Received request to add new payment to existing debt: {}", addPaymentRequestDto);
        var debtSummary = debtService.addPayment(userId, debtId, addPaymentRequestDto);
        return ResponseEntity.ok(debtSummary);
    }
}

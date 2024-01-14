package com.titamedia.challenge.controller;

import com.titamedia.challenge.dto.BankDto;
import com.titamedia.challenge.service.BankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "v1/debts")
@RequiredArgsConstructor
@Log4j2
public class DebtController {
    private final BankService bankService;

    @GetMapping({"{userId}/banks"})
    public ResponseEntity<List<BankDto>> listBanks(@PathVariable Integer userId) {
        log.info("Request to get list of user's banks");
        var bankList = bankService.findByUserId(userId);
        return ResponseEntity.ok(bankList);
    }
}

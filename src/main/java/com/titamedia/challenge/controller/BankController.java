package com.titamedia.challenge.controller;

import com.titamedia.challenge.dto.BankDto;
import com.titamedia.challenge.service.BankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "v1/banks")
@RequiredArgsConstructor
@Log4j2
public class BankController {
    private final BankService bankService;

    @GetMapping
    public ResponseEntity<List<BankDto>> findAll() {
        log.info("Request to get banks list");
        var bankList = bankService.findAll();
        return ResponseEntity.ok(bankList);
    }
}

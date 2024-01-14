package com.titamedia.challenge.service;

import com.titamedia.challenge.dto.BankDto;
import com.titamedia.challenge.mapper.BankMapper;
import com.titamedia.challenge.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {
    private final BankMapper bankMapper;
    private final BankRepository bankRepository;

    public List<BankDto> findAll() {
        var bankList = bankRepository.findAll();
        return bankMapper.toBankDto(bankList);
    }
}

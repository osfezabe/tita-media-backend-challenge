package com.titamedia.challenge.service;

import com.titamedia.challenge.dto.DebtDto;
import com.titamedia.challenge.mapper.DebtMapper;
import com.titamedia.challenge.repository.DebtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}

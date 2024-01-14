package com.titamedia.challenge.mapper;

import com.titamedia.challenge.domain.Bank;
import com.titamedia.challenge.dto.BankDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BankMapper {
    BankDto toBankDto(Bank bank);

    List<BankDto> toBankDto(Iterable<Bank> list);
}

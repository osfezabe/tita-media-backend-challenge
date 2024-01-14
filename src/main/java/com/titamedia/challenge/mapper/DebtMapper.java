package com.titamedia.challenge.mapper;

import com.titamedia.challenge.domain.Debt;
import com.titamedia.challenge.domain.DebtSummary;
import com.titamedia.challenge.dto.DebtDto;
import com.titamedia.challenge.dto.DebtSummaryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DebtMapper {
    DebtDto toDebtDto(Debt debt);

    List<DebtDto> toDebtDto(Iterable<Debt> debtList);

    DebtSummaryDto toDebtSummaryDto(DebtSummary summary);
}

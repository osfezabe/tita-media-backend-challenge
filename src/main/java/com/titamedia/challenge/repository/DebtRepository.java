package com.titamedia.challenge.repository;

import com.titamedia.challenge.domain.Debt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtRepository extends CrudRepository<Debt, Integer> {
    Iterable<Debt> findByUserIdAndBankId(Integer userId, Integer bankId);
}

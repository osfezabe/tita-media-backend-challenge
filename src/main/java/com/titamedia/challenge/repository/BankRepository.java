package com.titamedia.challenge.repository;

import com.titamedia.challenge.domain.Bank;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends CrudRepository<Bank, Integer> {

    @Query("select distinct d.bank from Debt d where d.user.id = :userId")
    List<Bank> findByUserId(Integer userId);
}

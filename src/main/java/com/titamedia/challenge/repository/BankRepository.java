package com.titamedia.challenge.repository;

import com.titamedia.challenge.domain.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<Bank, Integer> {

}

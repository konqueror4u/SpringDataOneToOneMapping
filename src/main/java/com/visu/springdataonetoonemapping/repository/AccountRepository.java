package com.visu.springdataonetoonemapping.repository;

import com.visu.springdataonetoonemapping.model.Account;
import com.visu.springdataonetoonemapping.model.AccountId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, AccountId> {
    List<Account> findByAccountType(String accountType);
}

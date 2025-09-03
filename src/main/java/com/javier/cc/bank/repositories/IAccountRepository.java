package com.javier.cc.bank.repositories;

import com.javier.cc.bank.models.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountRepository {
    List<Account> findAll();
    Optional<Account> findById(Long id);
    void deleteById(Long id);
    void save(Account account);
}

package com.javier.cc.bank.persistance;

import com.javier.cc.bank.models.Account;

import java.util.List;
import java.util.Optional;

//DAO (Data Accesss Object) la mejor manera para acceder a nuestra capa de persistencia.

public interface AccountDAO {

    List<Account> findAll();
    Optional<Account> findById(Long id);
    void deleteById(Long id);
    void save(Account account);
}

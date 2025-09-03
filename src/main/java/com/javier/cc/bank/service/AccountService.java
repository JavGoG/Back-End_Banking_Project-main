package com.javier.cc.bank.service;

import com.javier.cc.bank.models.Account;
import com.javier.cc.bank.persistance.AccountDAO;
import com.javier.cc.bank.repositories.AccountRepositoryImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class AccountService implements AccountDAO {

    @Autowired
    private AccountRepositoryImpl accountRepositoryImpl;

    public AccountService(AccountRepositoryImpl accountRepository){
        this.accountRepositoryImpl = accountRepository;
    }
    
    @Override
    public List<Account> findAll() {
        return (List<Account>) accountRepositoryImpl.findAll();
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepositoryImpl.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        accountRepositoryImpl.deleteById(id);
    }

    @Override
    public void save(Account account) {
        accountRepositoryImpl.save(account);
    }
}

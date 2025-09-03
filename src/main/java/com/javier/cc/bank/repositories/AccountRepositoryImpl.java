package com.javier.cc.bank.repositories;

import com.javier.cc.bank.models.Account;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AccountRepositoryImpl implements IAccountRepository{

    @Autowired
    AccountRepository accountRepository;

    public AccountRepositoryImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public List<Account> findAll(){
        System.out.println("Llamando al método real findAll!");
        return (List<Account>) accountRepository.findAll();
    }
    public Optional<Account> findById(Long id){
        System.out.println("Llamando al método real findById!");
        return accountRepository.findById(id);
    }
    public void deleteById(Long id){
        System.out.println("Llamando al método real deleteById!");
        accountRepository.deleteById(id);
    }
    public void save(Account account){
        System.out.println("Llamando al método real save!");
        accountRepository.save(account);
    }
}

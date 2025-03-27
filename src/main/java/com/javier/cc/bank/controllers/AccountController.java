package com.javier.cc.bank.controllers;

import com.javier.cc.bank.models.Account;
import com.javier.cc.bank.models.Customer;
import com.javier.cc.bank.repositories.AccountRepository;
import com.javier.cc.bank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CustomerRepository customerRepository;


    @GetMapping(value = "/account/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id){
        return new ResponseEntity(accountRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/account")
    public ResponseEntity<Account> postAccount(@RequestBody Account account){
        accountRepository.save(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @PutMapping(value="/account/{id}")
    public ResponseEntity<Account> putAccount(@RequestBody Account account, @PathVariable Long id, Account.TypeAccount typeAccount){
        Account accountToUpdate = accountRepository.findById(id).get();
        accountToUpdate.setNumber(account.getNumber());
        accountToUpdate.setType(account.getType(typeAccount));
        return new ResponseEntity<>(accountToUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value="/account/{id}")
    public ResponseEntity<Long> deleteAccount(@PathVariable Long id){
        accountRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(value="/account/{id}/customer")
    public ResponseEntity<List<Customer>> getCustomerForAccount(@PathVariable Long id,
                                                                @RequestParam(name = "userName", required = false) String userName,
                                                                @RequestParam(name = "email", required = false) String email,
                                                                @RequestParam(name = "address", required = false) String address,
                                                                @RequestParam(name = "name", required = false) String name) {
        if (name != null){
            if (email != null){
                if(address != null){
                    if(userName != null){
                        return new ResponseEntity<>(customerRepository.findByNameAndEmailAndUserNameAndAddress(name, email, userName, address), HttpStatus.OK);
                    }
                    return new ResponseEntity<>(customerRepository.findByNameAndEmailAndUserName(name, email, userName), HttpStatus.OK);
                }
                return new ResponseEntity<>(customerRepository.findByNameAndEmail(name, email), HttpStatus.OK);
            }
            return new ResponseEntity<>(customerRepository.findByName(name), HttpStatus.OK);
        }

        return new ResponseEntity<>(customerRepository.findAllById(Collections.singleton((id))), HttpStatus.OK);
    }
    @GetMapping(value = "/accounts/{type}")
    public ResponseEntity<List<Account>> getAccountsByType(@RequestParam(value = "typeAccount", required = false) Account.TypeAccount typeAccount){
        if (typeAccount != null) {
            return new ResponseEntity(accountRepository.findAllByTypeAccount(typeAccount), HttpStatus.OK);
        } return new ResponseEntity<>(accountRepository.findAll(),HttpStatus.OK);
    }

   @GetMapping(value = "/account/numbers")
    public ResponseEntity<Account> getAccountByNumber(@RequestParam (value = "number", required = false) Long number){
        return new ResponseEntity(accountRepository.findAllByNumber(number), HttpStatus.OK);
    }
}

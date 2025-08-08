package com.javier.cc.bank.controllers;

import com.javier.cc.bank.models.Account;
import com.javier.cc.bank.models.Customer;
import com.javier.cc.bank.repositories.AccountRepository;
import com.javier.cc.bank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerRepository customerRepository;
    private AccountRepository accountRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository, AccountRepository accountRepository){
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping(value="/customers/{id}")
    public ResponseEntity<Customer> putCustomer(@RequestBody Customer customer, @PathVariable Long id){
        Customer foundCustomer = customerRepository.findById(id).get();
        foundCustomer.setName(customer.getName());
        foundCustomer.setAddress(customer.getAddress());
        foundCustomer.setEmail(customer.getEmail());
        foundCustomer.setPassword(customer.getPassword());
        customerRepository.save(foundCustomer);
        return new ResponseEntity<>(foundCustomer, HttpStatus.OK);
    }
    @DeleteMapping(value="/customers/{id}")
    public ResponseEntity<Long> deleteCustomer(@PathVariable Long id){
        customerRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{customerId}/accounts")
    public ResponseEntity<List<Account>> getAccountsForCustomer(@PathVariable Long customerId) {
        return new ResponseEntity<>(accountRepository.findAllByCustomerId(customerId), HttpStatus.OK);
    }

}

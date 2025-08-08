package com.javier.cc.bank.dataloader;

import com.javier.cc.bank.models.Account;
import com.javier.cc.bank.models.Customer;
import com.javier.cc.bank.repositories.AccountRepository;
import com.javier.cc.bank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    @Autowired
    public DataLoader(AccountRepository accountRepository, CustomerRepository customerRepository){
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    public DataLoader(){}
    @Override
    public void run(ApplicationArguments args) throws Exception {


        char [] password1 = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        char [] password2 = {'m', 'y', 'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        char [] password3 = {'1', '2', '3', 'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        char [] password4 = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd', '1', '2', '3'};
        char [] password5 = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd','a', 'b', 'c'};

        Customer customer1 = new Customer("Michael Knight", " 4 Liberton Park", password1, "michaelknight@gmail.com", "Michael");
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Willie Sanders", " 25 Rose Crescent", password2, "williesanders@gmail.com", "Willie");
        customerRepository.save(customer2);
        Customer customer3 = new Customer("John Smith", " 1 Boulevard", password3, "johnsmith@gmail.com", "John");
        customerRepository.save(customer3);
        Customer customer4 = new Customer("Richard Mouse", " 7 Lasswade", password4, "richarmouse@gmail.com", "Richard");
        customerRepository.save(customer4);
        Customer customer5 = new Customer("David Horse", " 3 Newington Road", password5, "davidhorse@gmail.com", "David");
        customerRepository.save(customer5);

        Account accountS1 = new Account(1234, Account.TypeAccount.SAVINGS, customer1);
        accountRepository.save(accountS1);
        Account accountS2 = new Account(1235, Account.TypeAccount.SAVINGS, customer2);
        accountRepository.save(accountS2);
        Account accountS3 = new Account(1236, Account.TypeAccount.SAVINGS, customer3);
        accountRepository.save(accountS3);
        Account accountS4 = new Account(1237, Account.TypeAccount.SAVINGS, customer4);
        accountRepository.save(accountS4);
        Account accountS5 = new Account(1238, Account.TypeAccount.SAVINGS, customer5);
        accountRepository.save(accountS5);

        Account accountM1 = new Account(2234, Account.TypeAccount.MARKET, customer1);
        accountRepository.save(accountM1);
        Account accountM2 = new Account(2235, Account.TypeAccount.MARKET, customer2);
        accountRepository.save(accountM2);
        Account accountM3 = new Account(2236, Account.TypeAccount.MARKET, customer3);
        accountRepository.save(accountM3);
        Account accountM4 = new Account(2237, Account.TypeAccount.MARKET, customer4);
        accountRepository.save(accountM4);
        Account accountM5 = new Account(2238, Account.TypeAccount.MARKET, customer5);
        accountRepository.save(accountM5);


        Account accountB1 = new Account(3234, Account.TypeAccount.BROKERAGE, customer1);
        accountRepository.save(accountB1);
        Account accountB2 = new Account(3235, Account.TypeAccount.BROKERAGE, customer2);
        accountRepository.save(accountB2);
        Account accountB3 = new Account(3236, Account.TypeAccount.BROKERAGE, customer3);
        accountRepository.save(accountB3);
        Account accountB4 = new Account(3237, Account.TypeAccount.BROKERAGE, customer4);
        accountRepository.save(accountB4);
        Account accountB5 = new Account(3238, Account.TypeAccount.BROKERAGE, customer5);
        accountRepository.save(accountB5);


    }
}

package com.javier.cc.bank.controllers;

import com.javier.cc.bank.models.Account;
import com.javier.cc.bank.models.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountControllerTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres");

    @Autowired
    TestRestTemplate testRestTemplate;
    @Test
    void shouldFindAccountById(){
        ResponseEntity<Account> accountResponseEntity = testRestTemplate.exchange("/account/1", HttpMethod.GET,null,Account.class);
        assertThat(accountResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(accountResponseEntity.getBody()).isNotNull();
    }

    @Test
    void shouldPostAccount(){
        char [] password5 = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd','a', 'b', 'c'};
        Customer customer = new Customer("David Horse", " 3 Newington Road", password5, "davidhorse@gmail.com", "David");
        Account account = new Account(1, Account.TypeAccount.SAVINGS, customer);

        ResponseEntity<Account> accountResponseEntity = testRestTemplate.exchange("/account", HttpMethod.POST,new HttpEntity<Account>(account),Account.class);
        assertThat(accountResponseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(accountResponseEntity.getBody()).isNotNull();

    }
}
package com.javier.cc.bank.controllers;

import com.javier.cc.bank.models.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
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

}
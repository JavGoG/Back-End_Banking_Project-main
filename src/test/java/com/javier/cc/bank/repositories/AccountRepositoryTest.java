package com.javier.cc.bank.repositories;//package com.javier.cc.bank.repositories;

import com.javier.cc.bank.models.Account;
import com.javier.cc.bank.models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Testcontainers
@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AccountRepositoryTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres");

    @Autowired
    AccountRepository accountRepository;

    @Test
    void connectionEstablished() {
        assertThat(postgres.isCreated()).isTrue();
        assertThat(postgres.isRunning()).isTrue();
    }

    @BeforeEach
    void setUp(){

        List<Account> accounts = List.of(new Account(1, Account.TypeAccount.SAVINGS, new Customer()));
        List.of(new Account(2, Account.TypeAccount.SAVINGS, new Customer()));
        accountRepository.saveAll(accounts);
    }
    @Test
    void findAllByTypeAccount() {
    }

    @Test
    void findAllByNumber() {
    }

    @Test
    void findAllByCustomerId() {
    }
}
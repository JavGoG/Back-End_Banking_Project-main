package com.javier.cc.bank.repositories;//package com.javier.cc.bank.repositories;

import com.javier.cc.bank.models.Account;
import com.javier.cc.bank.models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Testcontainers
@ContextConfiguration
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes=AccountRepositoryTest.class)
@ComponentScan(value = "com.javier.cc.bank.repositories.AccountRepository")
@ImportResource("classpath:beans.xml")
@ImportTestcontainers
class AccountRepositoryTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres");

    @Autowired
    @Qualifier("accountRepository")
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
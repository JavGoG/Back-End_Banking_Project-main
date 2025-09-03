package com.javier.cc.bank;

import com.javier.cc.bank.models.Account;
import com.javier.cc.bank.models.Customer;
import com.javier.cc.bank.repositories.AccountRepository;
import com.javier.cc.bank.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.javier.cc.bank.models.Account.TypeAccount.SAVINGS;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(value = "com.javier.cc.bank.repositories , com.javier.cc.bank.models") //No leía las clases de este paquete.
@Configuration
class BankApplicationTests {

	@Autowired(required = true)
	AccountRepository accountRepository;

	@Autowired(required = true)
	CustomerRepository customerRepository;


	// Verify if the application is able to load Spring context successfully (Shorthand for "ApplicationContext",
	// which is the programming construction that the framework uses to access components from the Inversion-of-Control container
	// where they are cached)
	@Test
	public void contextLoads() {
	}

	@Test
	public void createCustomerAndAccountThenSave(){
		char[] password = {'p','a','s','s','w','o','r','d'};
		Customer customer = new Customer(0006L, "Jane", "Edinburgh Street", password,"janemartin@gmail.com", "janeMartin");
		customerRepository.save(customer);
		Account account = new Account(123456, SAVINGS,customer);
		accountRepository.save(account);
		assertEquals("Jane", customer.getName());

	}
	@Test
	public void findCustomerByNameAndEmail(){
		List<Customer> found = customerRepository.findByNameAndEmail("Jane", "janemartin@gmail.com");
		assertEquals("Jane",found.get(0).getName());
	}

	@Test
	public void findCustomerByNameAndEmailAndUserNameAndAddress(){
		List<Customer> found = customerRepository.findByNameAndEmailAndUserNameAndAddress("Jane", "janemartin@gmail.com", "janeMartin", "Edinburgh Street");
		assertEquals("Jane", found.get(0).getName());
	}

	@Test
	public void findAllAccountsByNumber(){
		List<Account> found = accountRepository.findAllByNumber(123456L);
		assertEquals(123456, found.get(0).getNumber());
	}

	@Test
	public void findAllAccountsByCustomerId(){
		List<Account> found = accountRepository.findAllByCustomerId(1L);
		// There is ambiguity calling assertEquals method with Long params:
		// Because there is another overloaded method with Object params
		// That is why I need to convert Id (Long) to String.
		assertEquals("1", found.get(0).getId().toString());
	}


}

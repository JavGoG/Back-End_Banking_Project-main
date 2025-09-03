package mock.service;

import com.javier.cc.bank.models.Account;
import com.javier.cc.bank.models.Customer;
import com.javier.cc.bank.repositories.AccountRepositoryImpl;
import com.javier.cc.bank.service.AccountService;
import mock.data.DataMockLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    //Given
    @Mock
    private AccountRepositoryImpl accountRepositoryImpl; //La dependencia de AccountService

    @InjectMocks
    private AccountService accountService; // La clase que estamos testeando

    @Test
    void TestFindAll(){
        //Given
        DataMockLoader dataMockLoader = new DataMockLoader();
        dataMockLoader.cargarDatos();
        //When
        when(accountRepositoryImpl.findAll()).thenReturn(DataMockLoader.getAccounts());
        List<Account> result = accountService.findAll();
        //Then
        System.out.println(result);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1234, result.get(0).getNumber());
        assertEquals("Michael Knight", result.get(0).getCustomer().getName());
        verify(accountRepositoryImpl).findAll();
    }

    @Test
    void testFindById(){
        //Given
        Long id = 1L;
        //When
        when(accountRepositoryImpl.findById(anyLong())).thenReturn(Optional.of(DataMockLoader.cargarAccount()));
        Optional<Account> account = accountService.findById(id);
        //Then
        System.out.println(account);
        assertNotNull(account);
        assertFalse(account.isEmpty());
        assertEquals(1235, account.get().getNumber());
        assertEquals("Willie Sanders", account.get().getCustomer().getName());
        verify(accountRepositoryImpl).findById(anyLong());
    }

    @Test
    void testDeleteById(){
        //Given
        Long id = 1L;
        //When
        accountRepositoryImpl.deleteById(id);
        //Then
        ArgumentCaptor<Long> accountArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(accountRepositoryImpl).deleteById(anyLong());
        verify(accountRepositoryImpl).deleteById(accountArgumentCaptor.capture());
        assertEquals(1L, accountArgumentCaptor.getValue());
    }

    @Test
    void testSave(){
        //Given
        char[] password3 = {'1', '2', '3', 'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        Customer customer3 = new Customer(0003L,"John Smith", " 1 Boulevard", password3, "johnsmith@gmail.com", "John");
        Account account = new Account(2236, Account.TypeAccount.MARKET, customer3);
        //When
        accountRepositoryImpl.save(account);
        //Then
        ArgumentCaptor<Account> accountArgumentCaptor = ArgumentCaptor.forClass(Account.class);
        verify(accountRepositoryImpl).save(accountArgumentCaptor.capture());
        assertEquals(2236, accountArgumentCaptor.getValue().getNumber());
        assertEquals("John Smith", accountArgumentCaptor.getValue().getCustomer().getName());
    }
}

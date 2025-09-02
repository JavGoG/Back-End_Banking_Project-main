package mock.service;

import com.javier.cc.bank.models.Account;
import com.javier.cc.bank.repositories.AccountRepositoryImpl;
import com.javier.cc.bank.service.AccountService;
import mock.data.DataMockLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    //Given
    @Mock
    private AccountRepositoryImpl accountRepositoryImpl; //La dependencia de AccountService

    @InjectMocks
    private AccountService accountService; // La clase que estamos testeando

    @BeforeEach
    void init(){
        DataMockLoader dataMockLoader = new DataMockLoader();
        dataMockLoader.cargarDatos();
    }

    @Test
    void TestFindAll(){
        //When
        Mockito.when(accountRepositoryImpl.findAll()).thenReturn(DataMockLoader.getAccounts());
        List<Account> result = accountService.findAll();
        //Then
        System.out.println(result);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1234, result.get(0).getNumber());
        assertEquals("Michael Knight", result.get(0).getCustomer().getName());
    }
}

package mock.service;

import com.javier.cc.bank.models.Customer;
import com.javier.cc.bank.repositories.CustomerRepository;
import com.javier.cc.bank.service.CustomerService;
import mock.data.DataMockLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    CustomerService customerService;
    
    @Test
    void TestFindAll(){
        //Given
        DataMockLoader dataMockLoader = new DataMockLoader();
        dataMockLoader.cargarDatos();
        //When
        when(customerRepository.findAll()).thenReturn(DataMockLoader.getCustomers());
        List<Customer> customers = customerRepository.findAll();
        //Then
        assertNotNull(customers);
        assertFalse(customers.isEmpty());
        assertEquals("David Horse", customers.get(4).getName());
        verify(customerRepository).findAll();
    }

    @Test
    void testSave(){
        //Given
        char[] password3 = {'1', '2', '3', 'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        Customer customer3 = new Customer("John Smith", " 1 Boulevard", password3, "johnsmith@gmail.com", "John");
        //When
        customerRepository.save(customer3);
        //Then
        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepository).save(customerArgumentCaptor.capture());
        assertNull(customerArgumentCaptor.getValue().getId());
        assertEquals("John Smith", customerArgumentCaptor.getValue().getName());
    }

    
}

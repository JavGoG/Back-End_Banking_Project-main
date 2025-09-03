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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
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
        List<Customer> customers = customerService.findAll();
        //Then
        assertNotNull(customers);
        assertFalse(customers.isEmpty());
        assertEquals("David Horse", customers.get(4).getName());
        verify(customerRepository).findAll();
    }

    @Test
    void testFindById(){
        //Given
        DataMockLoader.otroCargaCustomer();
        Long id = 5L;
        //When
        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(DataMockLoader.otroCargaCustomer()));
        Optional<Customer> customer = customerService.findById(id);
        //Then
        assertNotNull(customer);
        assertFalse(customer.isEmpty());
        assertEquals(5L, customer.get().getId());
        assertEquals("David Horse", customer.get().getName());
        verify(customerRepository).findById(id);
    }
    @Test
    void testDeleteById(){
        //Given
        DataMockLoader.otroCargaCustomer();
        Long id = 0005L;
        //When
        customerService.deleteById(id);
        //Then
        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(customerRepository).deleteById(anyLong());
        verify(customerRepository).deleteById(longArgumentCaptor.capture());
        assertEquals(0005L, longArgumentCaptor.getValue());
    }

    @Test
    void testSave(){
        //Given
        char[] password3 = {'1', '2', '3', 'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        Customer customer3 = new Customer(0003L,"John Smith", " 1 Boulevard", password3, "johnsmith@gmail.com", "John");
        //When
        customerRepository.save(customer3);
        //Then
        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepository).save(customerArgumentCaptor.capture());
        assertNotNull(customerArgumentCaptor.getValue().getId());
        assertEquals("John Smith", customerArgumentCaptor.getValue().getName());
    }

    
}

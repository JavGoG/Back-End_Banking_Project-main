package com.javier.cc.bank.repositories;

import com.javier.cc.bank.models.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerRepositoryImpl implements ICustomerRepository {
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(Long id){
        return customerRepository.findById(id);
    }

    public void deleteById(Long id){
        customerRepository.deleteById(id);
    }

    public void save(Customer customer){
        customerRepository.save(customer);
    }
}


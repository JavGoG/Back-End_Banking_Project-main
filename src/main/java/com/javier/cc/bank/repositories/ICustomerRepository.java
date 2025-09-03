package com.javier.cc.bank.repositories;

import com.javier.cc.bank.models.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    void deleteById(Long id);
    void save(Customer customer);

}

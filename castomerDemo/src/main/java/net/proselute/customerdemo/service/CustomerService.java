package net.proselute.customerdemo.service;

import net.proselute.customerdemo.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer getByID(Long id);

    void save(Customer customer);

    void delete(Long id);

    List<Customer> getAll();
}

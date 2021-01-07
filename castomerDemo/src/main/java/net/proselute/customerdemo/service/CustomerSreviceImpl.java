package net.proselute.customerdemo.service;

import lombok.extern.slf4j.Slf4j;
import net.proselute.customerdemo.model.Customer;
import net.proselute.customerdemo.repositoru.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerSreviceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer getByID(Long id) {
        log.info("IN customerRepository getByID {}",id);
        return customerRepository.findOne(id);
    }

    @Override
    public void save(Customer customer) {
        log.info("IN customerRepository save {}",customer);
     customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        log.info("IN customerRepository delete {}",id);
        customerRepository.delete(id);
    }

    @Override
    public List<Customer> getAll() {
        log.info("IN customerRepository getAll");
        return customerRepository.findAll();
    }
}

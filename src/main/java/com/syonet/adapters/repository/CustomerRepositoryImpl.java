package com.syonet.adapters.repository;

import java.util.List;

import com.syonet.domain.model.Customer;
import com.syonet.domain.repository.CustomerRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepositoryImpl implements CustomerRepository {

    public List<Customer> getCustomers() {
        return listAll();
    }

    public void saveCustomer(Customer customer) {
        persistAndFlush(customer);
    }

}

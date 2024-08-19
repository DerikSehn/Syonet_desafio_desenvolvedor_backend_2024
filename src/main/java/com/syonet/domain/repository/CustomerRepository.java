package com.syonet.domain.repository;

import java.util.List;

import com.syonet.domain.model.Customer;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface CustomerRepository extends PanacheRepository<Customer> {
    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);
}

package com.syonet.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.syonet.domain.model.Customer;
import com.syonet.domain.repository.CustomerRepository;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@QuarkusTest
public class CustomerServiceTest {

    @Inject
    CustomerRepository customerRepository;

    @Inject
    CustomerService customerService;

    @Test
    @Transactional
    public void testGetCustomers() {
        Customer customer1 = new Customer();
        customer1.email = "customer1@example.com";
        customer1.name = "nome1";

        Customer customer2 = new Customer();
        customer2.email = "customer2@example.com";
        customer2.name = "nome2";

        customerRepository.persistAndFlush(customer1);
        customerRepository.persistAndFlush(customer2);

        List<Customer> customers = customerService.getCustomers();
        assertEquals(3, customers.size());
    }

    /*
     * @Test
     * 
     * @Transactional
     * public void testGetCustomerById() {
     * Customer customer = new Customer();
     * customer.email = "customer@example.com";
     * customer.name = "nome";
     * 
     * customerRepository.persistAndFlush(customer);
     * 
     * Optional<Customer> foundCustomer = customerService.getCustomerById();
     * assertTrue(foundCustomer.isPresent());
     * assertEquals(customer.id, foundCustomer.get().id);
     * }
     */
}

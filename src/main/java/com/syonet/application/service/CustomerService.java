package com.syonet.application.service;

import java.util.List;

import com.syonet.domain.model.Customer;
import com.syonet.domain.repository.CustomerRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CustomerService {

    @Inject
    CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.listAll();
    }

    @Transactional
    public void saveCustomer(Customer customer) {
        customerRepository.persistAndFlush(customer);
    }
    /*
     * public List<Customer> getCustomers(int page, int size) {
     * 
     * TypedQuery<Customer> query =
     * entityManager.createQuery("SELECT c FROM Customer c", Customer.class);
     * 
     * query.setFirstResult(page * size);
     * query.setMaxResults(size);
     * 
     * return query.getResultList();
     * }
     * 
     * public Optional<Customer> getCustomerById(Long id) {
     * return customerRepository.findByIdOptional(id);
     * }
     */

    /*
     * @Transactional
     * public void deleteCustomer(Long id) {
     * customerRepository.deleteById(id);
     * }
     */

}

package com.syonet.adapters.rest;

import java.util.List;

import com.syonet.application.service.CustomerService;
import com.syonet.domain.model.Customer;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    CustomerService customerService;

    @GET
    public Response getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        return Response.ok(customers).build();
    }

    @POST
    @Transactional
    public Response createCustomer(Customer customer) {
        customerService.saveCustomer(customer);
        return Response.status(Response.Status.CREATED).build();
    }

}

package com.example.crm.service;

import com.example.crm.dto.request.AddCustomerRequest;
import com.example.crm.dto.request.UpdateCustomerRequest;
import com.example.crm.dto.response.AddCustomerResponse;
import com.example.crm.dto.response.CustomerResponse;
import com.example.crm.dto.response.UpdateCustomerResponse;
import com.example.crm.entity.Customer;
import com.example.crm.exception.CustomerNotFoundException;
import com.example.crm.repository.CustomerRepository;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.function.Supplier;

@Service
public class CustomerServiceImpl implements CustomerService{

    private static final Supplier<CustomerNotFoundException>
            customerNotFoundExceptionSupplier =
            () -> new CustomerNotFoundException(
                    "Cannot find the customer",
                    1000,
                    "821b0947-4758-49da-a0f6-a08fad807016"
            );

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @SneakyThrows
    @Override
    public CustomerResponse findById(String identity) {
        return modelMapper.map(customerRepository.findById(identity)
                .orElseThrow(customerNotFoundExceptionSupplier),CustomerResponse.class);
    }

    @Override
    @Transactional
    public AddCustomerResponse createCustomer(AddCustomerRequest request) {
        var customer = modelMapper.map(request, Customer.class);
        return modelMapper.map(customerRepository.save(customer),AddCustomerResponse.class);
    }

    @Override
    @Transactional
    public CustomerResponse removeById(String identity) {
        var customer = customerRepository.findById(identity)
                .orElseThrow(customerNotFoundExceptionSupplier);
        customerRepository.deleteById(identity);
        return modelMapper.map(customer,CustomerResponse.class);
    }

    @Override
    @Transactional
    public UpdateCustomerResponse updateCustomer(String identity, UpdateCustomerRequest request) {
        var customer = customerRepository.findById(identity)
                .orElseThrow(customerNotFoundExceptionSupplier);
        modelMapper.map(request,customer);
        return modelMapper.map(
                customerRepository.saveAndFlush(customer),UpdateCustomerResponse.class);
    }

}

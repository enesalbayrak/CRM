package com.example.crm.service;

import com.example.crm.dto.request.AddCustomerRequest;
import com.example.crm.dto.request.UpdateCustomerRequest;
import com.example.crm.dto.response.AddCustomerResponse;
import com.example.crm.dto.response.CustomerResponse;
import com.example.crm.dto.response.UpdateCustomerResponse;

public interface CustomerService {
    CustomerResponse findById(String identity);

    AddCustomerResponse createCustomer(AddCustomerRequest request);

    CustomerResponse removeById(String identity);

    UpdateCustomerResponse updateCustomer(String identity, UpdateCustomerRequest request);
}

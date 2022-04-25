package com.example.crm.dto.request;

import com.example.crm.dto.response.AddressResponse;
import com.example.crm.entity.CustomerType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateCustomerRequest {
    private String email;
    private String phone;
    private List<AddressResponse> addresses;
    private CustomerType type;
}

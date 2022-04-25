package com.example.crm.dto.response;

import com.example.crm.entity.CustomerType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CustomerResponse {
    private String identity;
    private String fullname;
    private String email;
    private String phone;
    private int birthYear;
    private List<AddressResponse> addresses;
    private CustomerType type;
}

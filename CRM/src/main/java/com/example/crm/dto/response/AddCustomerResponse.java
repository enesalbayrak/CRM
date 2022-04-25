package com.example.crm.dto.response;

import com.example.crm.entity.CustomerType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AddCustomerResponse {
    private String identity;
    private String fullname;
    private String email;
    private String phone;
    private int birthYear;
    private List<AddressResponse> addresses;
    private CustomerType type;
}

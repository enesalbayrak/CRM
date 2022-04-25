package com.example.crm.dto.response;

import com.example.crm.entity.AddressType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddressResponse {
    private String street;
    private String city;
    private String country;
    private String zipCode;
    private AddressType type;
}

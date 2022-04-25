package com.example.crm.dto.request;

import com.example.crm.entity.AddressType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddressRequest {
    private String street;
    private String city;
    private String country;
    private String zipCode;
    private AddressType type;
}

package com.example.crm.dto.request;

import com.example.crm.entity.CustomerType;
import com.example.crm.validation.Email;
import com.example.crm.validation.TcKimlikNo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AddCustomerRequest {
    @TcKimlikNo
    private String identity;
    @Size(min = 5)
    private String fullname;
    @Email
    private String email;
    @NotBlank
    private String phone;
    @Max(2008)
    private int birthYear;
    private List<AddressRequest> addresses;
    private CustomerType type;

}

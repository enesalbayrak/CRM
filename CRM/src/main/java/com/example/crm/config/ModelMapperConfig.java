package com.example.crm.config;

import com.example.crm.dto.request.UpdateCustomerRequest;
import com.example.crm.entity.Address;
import com.example.crm.entity.Customer;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class ModelMapperConfig {

    private static final Converter<UpdateCustomerRequest, Customer>
    UPDATE_CUSTOMER_REQUEST_CUSTOMER_CONVERTER= (context) -> {
        var customer = context.getDestination();
        var updateCusReq = context.getSource();

        customer.setEmail(updateCusReq.getEmail());
        customer.setPhone(updateCusReq.getPhone());
        customer.setType(updateCusReq.getType());
        var addresses = updateCusReq.getAddresses()
                .stream()
                .map( address -> {
                    var addr = new Address();
                    addr.setCity(address.getCity());
                    addr.setCountry(address.getCountry());
                    addr.setType(address.getType());
                    addr.setZipCode(address.getZipCode());
                    addr.setStreet(address.getStreet());
                    return addr;
                }).toList();
        customer.setAddresses(new ArrayList<>(addresses));
        return customer;
    };
    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();
        modelMapper.addConverter(UPDATE_CUSTOMER_REQUEST_CUSTOMER_CONVERTER,
                UpdateCustomerRequest.class,Customer.class);
        return modelMapper;
    }
}

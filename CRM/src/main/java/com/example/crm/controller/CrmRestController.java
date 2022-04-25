package com.example.crm.controller;

import com.example.crm.dto.error.ErrorMessage;
import com.example.crm.dto.request.AddCustomerRequest;
import com.example.crm.dto.request.UpdateCustomerRequest;
import com.example.crm.dto.response.AddCustomerResponse;
import com.example.crm.dto.response.CustomerResponse;
import com.example.crm.dto.response.UpdateCustomerResponse;
import com.example.crm.exception.CustomerNotFoundException;
import com.example.crm.service.CustomerService;
import com.example.crm.validation.TcKimlikNo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Valid
public class CrmRestController {
    private final CustomerService customerService;

    @GetMapping("/{identity}")
    public ResponseEntity<CustomerResponse> getCustomerByIdentity(@PathVariable @TcKimlikNo String identity){
        return ResponseEntity.ok(customerService.findById(identity));
    }
    @PostMapping
    public AddCustomerResponse addCustomer(@RequestBody @Validated AddCustomerRequest request){
        return customerService.createCustomer(request);
    }

    @DeleteMapping("/{identity}")
    public CustomerResponse deleteCustomerByIdentity(@PathVariable @TcKimlikNo String identity){
        return customerService.removeById(identity);
    }
    @PutMapping(value = "{identity}")
    public UpdateCustomerResponse updateCustomer(
            @PathVariable @TcKimlikNo String identity,
            @RequestBody @Validated UpdateCustomerRequest request){
        return customerService.updateCustomer(identity,request);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleCustomerNotFoundException(
            CustomerNotFoundException e) {
        return new ErrorMessage(e.getMessage(),
                e.getI18nId(),
                e.getDebugId());
    }
}

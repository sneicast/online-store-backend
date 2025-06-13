package dev.scastillo.customer.adapter.web.controller;

import dev.scastillo.customer.adapter.web.dto.CustomerCreateRequestDto;
import dev.scastillo.customer.adapter.web.dto.CustomerDto;
import dev.scastillo.customer.adapter.web.mapper.CustomerMapper;
import dev.scastillo.customer.domain.model.Customer;
import dev.scastillo.customer.domain.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @PostMapping
    public CustomerDto createCustomer(@RequestBody CustomerCreateRequestDto request) {
        Customer customer =  customerService.createCustomer(customerMapper.toDomain(request));
        CustomerDto customerDto = customerMapper.toDto(customer);
        return customerDto;
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable UUID id) {
        Customer customer = customerService.getCustomerById(id);
        return customerMapper.toDto(customer);
    }

    @GetMapping("/username/{username}")
    public CustomerDto getCustomerByUsername(@PathVariable String username) {
        Customer customer = customerService.getCustomerByUsername(username);
        return customerMapper.toDto(customer);
    }
}

package dev.scastillo.customer.adapter.web.controller;

import dev.scastillo.customer.adapter.web.dto.CustomerAddressDto;
import dev.scastillo.customer.adapter.web.dto.CustomerAddressRequestDto;
import dev.scastillo.customer.adapter.web.mapper.CustomerAddressMapper;
import dev.scastillo.customer.domain.model.CustomerAddress;
import dev.scastillo.customer.domain.service.CustomerAddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers/{customerId}/addresses")
@AllArgsConstructor
public class CustomerAddressController {
    private  final CustomerAddressService customerAddressService;
    private  final CustomerAddressMapper customerAddressMapper;

    @PostMapping
    public CustomerAddressDto createCustomerAddress(@PathVariable String customerId, @RequestBody CustomerAddressRequestDto request) {
        CustomerAddress address = customerAddressService.createCustomerAddress(UUID.fromString(customerId), customerAddressMapper.toDomain(request));
        return customerAddressMapper.toDto(address);
    }

    @GetMapping("/{id}")
    public CustomerAddressDto getCustomerAddressById(@PathVariable String customerId, @PathVariable String id) {
        CustomerAddress address = customerAddressService.getCustomerAddressById(UUID.fromString(customerId), UUID.fromString(id));
        return customerAddressMapper.toDto(address);
    }
    @GetMapping
    public List<CustomerAddressDto> getCustomerAddressesByCustomerId(@PathVariable String customerId) {
        List<CustomerAddress> addressList = customerAddressService.getCustomerAddressByCustomerId(UUID.fromString(customerId));
        return addressList.stream()
                .map(customerAddressMapper::toDto)
                .toList();
    }
    @PutMapping("/{id}")
    public CustomerAddressDto updateCustomerAddress(@PathVariable String customerId, @PathVariable String id, @RequestBody CustomerAddressRequestDto request) {
        CustomerAddress customerAddress = customerAddressMapper.toDomain(request);
        customerAddress.setId(UUID.fromString(id));
        CustomerAddress address =  customerAddressService.updateCustomerAddress(UUID.fromString(customerId), customerAddress);
        return customerAddressMapper.toDto(address);
    }
    @DeleteMapping("/{id}")
    public void deleteCustomerAddress(@PathVariable String customerId, @PathVariable String id) {
        customerAddressService.deleteCustomerAddress(UUID.fromString(customerId), UUID.fromString(id));
    }



}

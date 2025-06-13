package dev.scastillo.customer.application.service;

import dev.scastillo.customer.domain.model.Customer;
import dev.scastillo.customer.domain.model.CustomerAddress;
import dev.scastillo.customer.domain.repository.CustomerAddressRepository;
import dev.scastillo.customer.domain.repository.CustomerRepository;
import dev.scastillo.customer.domain.service.CustomerAddressService;
import dev.scastillo.customer.shared.exception.NotFoundException;
import dev.scastillo.customer.shared.util.DateTimeUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerAddressServiceImpl implements CustomerAddressService {
    private final CustomerAddressRepository customerAddressRepository;
    private final CustomerRepository customerRepository;

    @Override
    public CustomerAddress createCustomerAddress(UUID customerId, CustomerAddress customerAddress) {
        Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new NotFoundException("Customer not found with id: " + customerId));
        customerAddress.setCustomer(customer);
        customerAddress.setId(UUID.randomUUID());
        customerAddress.setCreateAt(DateTimeUtils.now());
        customerAddress.setUpdateAt(DateTimeUtils.now());
        return customerAddressRepository.save(customerAddress);
    }

    @Override
    public CustomerAddress getCustomerAddressById(UUID customerId, UUID id) {
        return customerAddressRepository.findByCustomerIdAndId(customerId, id).orElseThrow(
            () -> new NotFoundException("Customer address not found with id: " + id)
        );
    }

    @Override
    public List<CustomerAddress> getCustomerAddressByCustomerId(UUID customerId) {
        return customerAddressRepository.findAllByCustomerId(customerId);
    }

    @Override
    public CustomerAddress updateCustomerAddress(UUID customerId, CustomerAddress customerAddress) {
        CustomerAddress existingAddress = customerAddressRepository.findByCustomerIdAndId(customerId, customerAddress.getId())
            .orElseThrow(() -> new NotFoundException("Customer address not found with id: " + customerAddress.getId()));

        existingAddress.setTitle(customerAddress.getTitle());
        existingAddress.setAddress(customerAddress.getAddress());
        existingAddress.setCity(customerAddress.getCity());
        existingAddress.setPostalCode(customerAddress.getPostalCode());
        existingAddress.setIsDefault(customerAddress.getIsDefault());
        existingAddress.setUpdateAt(DateTimeUtils.now());


        return customerAddressRepository.save(existingAddress);
    }

    @Override
    public void deleteCustomerAddress(UUID customerId, UUID id) {
        customerAddressRepository.deleteByIdAndCustomerId(id, customerId);
    }
}

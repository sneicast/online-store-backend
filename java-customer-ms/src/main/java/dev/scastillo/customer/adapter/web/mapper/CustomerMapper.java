package dev.scastillo.customer.adapter.web.mapper;

import dev.scastillo.customer.adapter.web.dto.CustomerCreateRequestDto;
import dev.scastillo.customer.adapter.web.dto.CustomerDto;
import dev.scastillo.customer.domain.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toDomain(CustomerCreateRequestDto dto);
    CustomerDto toDto(Customer customer);
}

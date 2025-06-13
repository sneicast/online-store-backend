package dev.scastillo.customer.adapter.web.mapper;

import dev.scastillo.customer.adapter.web.dto.CustomerAddressDto;
import dev.scastillo.customer.adapter.web.dto.CustomerAddressRequestDto;
import dev.scastillo.customer.domain.model.CustomerAddress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerAddressMapper {
    CustomerAddress toDomain(CustomerAddressRequestDto dto);
    CustomerAddressDto toDto(CustomerAddress customerAddress);
}

package ee.bcs.myApp.bank.customer;

import org.mapstruct.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    Customer toEntity(CustomerDto dto);

    CustomerDto toDto(Customer entity);
    List<CustomerDto> toDtos(List <Customer> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(CustomerDto dto, @MappingTarget Customer entity);
}

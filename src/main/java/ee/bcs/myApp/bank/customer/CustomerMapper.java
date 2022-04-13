package ee.bcs.myApp.bank.customer;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")

public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    Customer toEntity(CustomerDto dto);

    CustomerDto toDto(Customer entity);

    List<CustomerDto> toDtos(List<Customer> customers);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

    @Mapping(target = "id", ignore = true)
    void updateEntity(CustomerDto dto, @MappingTarget Customer entity);

}

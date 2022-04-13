package ee.bcs.myApp.bank.customer;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    Customer toEntity(CustomerDto dto);

    CustomerDto toDto(Customer entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(CustomerDto dto, @MappingTarget Customer entity);
}

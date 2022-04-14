package ee.bcs.myApp.bank.domain.customer;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    Customer toEntity(CustomerDto Dto);
    // sisse võetakse customer Dto, ignoreeri lõpptulemuse id-d. Inore on target põhine

    CustomerDto toDto(Customer entity);

    List<CustomerDto> toDtos(List<Customer> entity);



    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(CustomerDto dto, @MappingTarget Customer entity);
}
// Dto peame kanda väärtused üle Entityle, sellele me Mapime asju.
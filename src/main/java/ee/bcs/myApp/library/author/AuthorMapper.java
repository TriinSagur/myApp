package ee.bcs.myApp.library.author;

import ee.bcs.myApp.bank.domain.customer.Customer;
import ee.bcs.myApp.bank.domain.customer.CustomerDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AuthorMapper {
    Author toEntity(AuthorDto authorDto);

    AuthorDto toDto(Author author);

    List<AuthorDto> toDtos(List<Author> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(AuthorDto authorDto, @MappingTarget Author author);
}

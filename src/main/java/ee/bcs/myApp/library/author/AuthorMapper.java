package ee.bcs.myApp.library.author;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AuthorMapper {
    Author toEntity(AuthorDto authorDto);

    AuthorDto toDto(Author author);

    List<AuthorDto> toDtos(List<Author> authors);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(AuthorDto dto, @MappingTarget Author entity);
}

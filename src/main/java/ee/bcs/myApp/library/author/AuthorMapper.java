package ee.bcs.myApp.library.author;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AuthorMapper {
    @Mapping(target = "id", ignore = true)
    Author authorToEntity(AuthorDto authorDto);

    AuthorDto authorToDto(Author author);

    List<AuthorDto> toDtos(List<Author> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateAuthorFromAuthorDto(AuthorDto authorDto, @MappingTarget Author author);
}

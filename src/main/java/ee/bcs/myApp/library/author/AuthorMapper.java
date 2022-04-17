package ee.bcs.myApp.library.author;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AuthorMapper {

    Author toEntity(AuthorDto authorDto);

    AuthorDto toDto(Author author);

    List <AuthorDto> toDtos(List <Author> authors);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAuthorFromAuthorDto(AuthorDto authorDto, @MappingTarget Author author);


}

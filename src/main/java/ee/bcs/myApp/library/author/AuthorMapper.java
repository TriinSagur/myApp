package ee.bcs.myApp.library.author;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AuthorMapper {

    Author toEntity(AuthorDto authorDto);  // algne nimetus oli: authorDtoToAuthor, muutsin ära - DTO sisse välja "Entity" => toEntity

    AuthorDto toDto(Author author); // alne nimi authorToAuthorDto, uus nimi pandud , sest siisse autor ja välja DTO, siis toAutorDTO

    List<AuthorDto> toDtos(List<Author> entities);   // kus seda tarvis on?

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(AuthorDto authorDto, @MappingTarget Author author);
}

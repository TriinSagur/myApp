package ee.bcs.myApp.library.bookauthor;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookAuthorMapper {
    @Mapping(source = "bookTitle", target = "book.title")
    @Mapping(source = "year", target = "book.year")
    @Mapping(source = "authorFirstName", target = "author.firstName")
    @Mapping(source = "authorLastName", target = "author.lastName")
    BookAuthor toEntity(BookAuthorDto bookAuthorDto);

    @InheritInverseConfiguration(name = "toEntity")
    BookAuthorDto toDto(BookAuthor bookAuthor);

    List<BookAuthorDto> toDtos(List<BookAuthor> entities);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(BookAuthorDto bookAuthorDto, @MappingTarget BookAuthor bookAuthor);
}

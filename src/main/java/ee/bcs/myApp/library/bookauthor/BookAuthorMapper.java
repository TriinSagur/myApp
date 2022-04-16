package ee.bcs.myApp.library.bookauthor;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookAuthorMapper {
    @Mapping(source = "bookTitle", target = "book.title")
    @Mapping(source = "authorFirstName", target = "author.firstName")
    @Mapping(source = "authorLastName", target = "author.lastName")
    BookAuthor toEntity(BookAuthorDto bookAuthorDto);

    @InheritInverseConfiguration(name = "bookAuthorDtoToBookAuthor")
    BookAuthorDto ToDto(BookAuthor bookAuthor);

    @InheritConfiguration(name = "bookAuthorDtoToBookAuthor")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(BookAuthorDto bookAuthorDto, @MappingTarget BookAuthor bookAuthor);
}

package ee.bcs.myApp.library.bookauthor;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookAuthorMapper {
    @Mapping(source = "bookId", target = "book.id")
    @Mapping(source = "bookTitle", target = "book.title")
    @Mapping(source = "bookYear", target = "book.year")
    @Mapping(source = "authorId", target = "author.id")
    @Mapping(source = "authorFirstName", target = "author.firstName")
    @Mapping(source = "authorLastName", target = "author.lastName")
    BookAuthor bookAuthorDtoToBookAuthor(BookAuthorDto bookAuthorDto);

    @InheritInverseConfiguration(name = "bookAuthorDtoToBookAuthor")
    BookAuthorDto toDto(BookAuthor bookAuthor);

    List <BookAuthorDto> toDtos(List <BookAuthor> bookAuthors);

    @InheritConfiguration(name = "bookAuthorDtoToBookAuthor")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookAuthorFromBookAuthorDto(BookAuthorDto bookAuthorDto, @MappingTarget BookAuthor bookAuthor);
}

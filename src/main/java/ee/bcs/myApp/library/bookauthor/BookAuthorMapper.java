package ee.bcs.myApp.library.bookauthor;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookAuthorMapper {

    @Mapping(target = "book.title", source = "bookTitle")
    @Mapping(target = "book.year", source = "bookYear")
    @Mapping(target = "author.firstName", source = "authorFirstName")
    @Mapping(target = "author.lastName", source = "authorLastName")
    BookAuthor toEntity(BookAuthorDto dto);


}

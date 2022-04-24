package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.service.BookAuthorRequest;
import ee.bcs.myApp.library.service.BookAuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookAuthorMapper {

    @Mapping(target = "bookId", source = "book.id")
    @Mapping(target = "bookTitle", source = "book.title")
    @Mapping(target = "bookYear", source = "book.year")
    @Mapping(target = "authorId", source = "author.id")
    @Mapping(target = "authorFirstName", source = "author.firstName")
    @Mapping(target = "authorLastName", source = "author.lastName")
    BookAuthorResponse toBookAuthorResponse(BookAuthor bookAuthor);

    List <BookAuthorResponse> toBookAuthorResponses(List <BookAuthor> bookAuthor);

    @Mapping(source = "bookTitle", target = "book.title")
    @Mapping(source = "bookYear", target = "book.year")
    @Mapping(source = "authorFirstName", target = "author.firstName")
    @Mapping(source = "authorLastName", target = "author.lastName")
    BookAuthor toAddBookAuthorEntity(BookAuthorRequest bookAuthorRequest);

}



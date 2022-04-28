package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.book.Book;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-19T13:54:52+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class BookAuthorMapperImpl implements BookAuthorMapper {

    @Override
    public BookAuthor toEntity(BookAuthorDto dto) {
        if ( dto == null ) {
            return null;
        }

        BookAuthor bookAuthor = new BookAuthor();

        bookAuthor.setBook( bookAuthorDtoToBook( dto ) );
        bookAuthor.setAuthor( bookAuthorDtoToAuthor( dto ) );

        return bookAuthor;
    }

    protected Book bookAuthorDtoToBook(BookAuthorDto bookAuthorDto) {
        if ( bookAuthorDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setTitle( bookAuthorDto.getBookTitle() );
        book.setYear( bookAuthorDto.getBookYear() );

        return book;
    }

    protected Author bookAuthorDtoToAuthor(BookAuthorDto bookAuthorDto) {
        if ( bookAuthorDto == null ) {
            return null;
        }

        Author author = new Author();

        author.setFirstName( bookAuthorDto.getAuthorFirstName() );
        author.setLastName( bookAuthorDto.getAuthorLastName() );

        return author;
    }
}

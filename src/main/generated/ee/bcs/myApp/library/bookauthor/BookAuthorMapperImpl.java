package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.service.BookAuthorRequest;
import ee.bcs.myApp.library.service.BookAuthorResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-24T20:51:06+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class BookAuthorMapperImpl implements BookAuthorMapper {

    @Override
    public BookAuthorResponse toBookAuthorResponse(BookAuthor bookAuthor) {
        if ( bookAuthor == null ) {
            return null;
        }

        BookAuthorResponse bookAuthorResponse = new BookAuthorResponse();

        bookAuthorResponse.setBookTitle( bookAuthorBookTitle( bookAuthor ) );
        bookAuthorResponse.setBookYear( bookAuthorBookYear( bookAuthor ) );
        bookAuthorResponse.setAuthorFirstName( bookAuthorAuthorFirstName( bookAuthor ) );
        bookAuthorResponse.setAuthorLastName( bookAuthorAuthorLastName( bookAuthor ) );
        bookAuthorResponse.setId( bookAuthor.getId() );

        return bookAuthorResponse;
    }

    @Override
    public List<BookAuthorResponse> toBookAuthorResponses(List<BookAuthor> bookAuthor) {
        if ( bookAuthor == null ) {
            return null;
        }

        List<BookAuthorResponse> list = new ArrayList<BookAuthorResponse>( bookAuthor.size() );
        for ( BookAuthor bookAuthor1 : bookAuthor ) {
            list.add( toBookAuthorResponse( bookAuthor1 ) );
        }

        return list;
    }

    @Override
    public BookAuthor toAddBookAuthorEntity(BookAuthorRequest bookAuthorRequest) {
        if ( bookAuthorRequest == null ) {
            return null;
        }

        BookAuthor bookAuthor = new BookAuthor();

        bookAuthor.setBook( bookAuthorRequestToBook( bookAuthorRequest ) );
        bookAuthor.setAuthor( bookAuthorRequestToAuthor( bookAuthorRequest ) );

        return bookAuthor;
    }

    private String bookAuthorBookTitle(BookAuthor bookAuthor) {
        if ( bookAuthor == null ) {
            return null;
        }
        Book book = bookAuthor.getBook();
        if ( book == null ) {
            return null;
        }
        String title = book.getTitle();
        if ( title == null ) {
            return null;
        }
        return title;
    }

    private Integer bookAuthorBookYear(BookAuthor bookAuthor) {
        if ( bookAuthor == null ) {
            return null;
        }
        Book book = bookAuthor.getBook();
        if ( book == null ) {
            return null;
        }
        Integer year = book.getYear();
        if ( year == null ) {
            return null;
        }
        return year;
    }

    private String bookAuthorAuthorFirstName(BookAuthor bookAuthor) {
        if ( bookAuthor == null ) {
            return null;
        }
        Author author = bookAuthor.getAuthor();
        if ( author == null ) {
            return null;
        }
        String firstName = author.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String bookAuthorAuthorLastName(BookAuthor bookAuthor) {
        if ( bookAuthor == null ) {
            return null;
        }
        Author author = bookAuthor.getAuthor();
        if ( author == null ) {
            return null;
        }
        String lastName = author.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    protected Book bookAuthorRequestToBook(BookAuthorRequest bookAuthorRequest) {
        if ( bookAuthorRequest == null ) {
            return null;
        }

        Book book = new Book();

        book.setTitle( bookAuthorRequest.getBookTitle() );
        book.setYear( bookAuthorRequest.getBookYear() );

        return book;
    }

    protected Author bookAuthorRequestToAuthor(BookAuthorRequest bookAuthorRequest) {
        if ( bookAuthorRequest == null ) {
            return null;
        }

        Author author = new Author();

        author.setFirstName( bookAuthorRequest.getAuthorFirstName() );
        author.setLastName( bookAuthorRequest.getAuthorLastName() );

        return author;
    }
}

package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.book.Book;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-21T10:01:54+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Amazon.com Inc.)"
)
@Component
public class BookAuthorMapperImpl implements BookAuthorMapper {

    @Override
    public BookAuthor toEntity(BookAuthorDto bookAuthorDto) {
        if ( bookAuthorDto == null ) {
            return null;
        }

        BookAuthor bookAuthor = new BookAuthor();

        bookAuthor.setBook( bookAuthorDtoToBook( bookAuthorDto ) );
        bookAuthor.setAuthor( bookAuthorDtoToAuthor( bookAuthorDto ) );
        bookAuthor.setId( bookAuthorDto.getId() );

        return bookAuthor;
    }

    @Override
    public BookAuthorDto toDto(BookAuthor bookAuthor) {
        if ( bookAuthor == null ) {
            return null;
        }

        BookAuthorDto bookAuthorDto = new BookAuthorDto();

        bookAuthorDto.setBookTitle( bookAuthorBookTitle( bookAuthor ) );
        bookAuthorDto.setAuthorFirstName( bookAuthorAuthorFirstName( bookAuthor ) );
        bookAuthorDto.setAuthorLastName( bookAuthorAuthorLastName( bookAuthor ) );
        bookAuthorDto.setId( bookAuthor.getId() );

        return bookAuthorDto;
    }

    @Override
    public List<BookAuthorDto> toDtos(List<BookAuthor> entities) {
        if ( entities == null ) {
            return null;
        }

        List<BookAuthorDto> list = new ArrayList<BookAuthorDto>( entities.size() );
        for ( BookAuthor bookAuthor : entities ) {
            list.add( toDto( bookAuthor ) );
        }

        return list;
    }

    @Override
    public void updateEntity(BookAuthorDto bookAuthorDto, BookAuthor bookAuthor) {
        if ( bookAuthorDto == null ) {
            return;
        }

        if ( bookAuthor.getBook() == null ) {
            bookAuthor.setBook( new Book() );
        }
        bookAuthorDtoToBook1( bookAuthorDto, bookAuthor.getBook() );
        if ( bookAuthor.getAuthor() == null ) {
            bookAuthor.setAuthor( new Author() );
        }
        bookAuthorDtoToAuthor1( bookAuthorDto, bookAuthor.getAuthor() );
        if ( bookAuthorDto.getId() != null ) {
            bookAuthor.setId( bookAuthorDto.getId() );
        }
    }

    protected Book bookAuthorDtoToBook(BookAuthorDto bookAuthorDto) {
        if ( bookAuthorDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setTitle( bookAuthorDto.getBookTitle() );

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

    protected void bookAuthorDtoToBook1(BookAuthorDto bookAuthorDto, Book mappingTarget) {
        if ( bookAuthorDto == null ) {
            return;
        }

        if ( bookAuthorDto.getBookTitle() != null ) {
            mappingTarget.setTitle( bookAuthorDto.getBookTitle() );
        }
    }

    protected void bookAuthorDtoToAuthor1(BookAuthorDto bookAuthorDto, Author mappingTarget) {
        if ( bookAuthorDto == null ) {
            return;
        }

        if ( bookAuthorDto.getAuthorFirstName() != null ) {
            mappingTarget.setFirstName( bookAuthorDto.getAuthorFirstName() );
        }
        if ( bookAuthorDto.getAuthorLastName() != null ) {
            mappingTarget.setLastName( bookAuthorDto.getAuthorLastName() );
        }
    }
}

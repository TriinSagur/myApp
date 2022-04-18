package ee.bcs.myApp.library.bookout;

import ee.bcs.myApp.library.book.Book;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-17T16:19:06+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Amazon.com Inc.)"
)
@Component
public class BookOutMapperImpl implements BookOutMapper {

    @Override
    public BookOut toEntity(BookOutDto bookOutDto) {
        if ( bookOutDto == null ) {
            return null;
        }

        BookOut bookOut = new BookOut();

        bookOut.setBook( bookOutDtoToBook( bookOutDto ) );
        bookOut.setId( bookOutDto.getId() );
        bookOut.setIsReturned( bookOutDto.getIsReturned() );

        return bookOut;
    }

    @Override
    public BookOutDto toDto(BookOut bookOut) {
        if ( bookOut == null ) {
            return null;
        }

        Integer bookId = null;
        String bookTitle = null;
        Integer bookYear = null;
        Integer id = null;
        Boolean isReturned = null;

        bookId = bookOutBookId( bookOut );
        bookTitle = bookOutBookTitle( bookOut );
        bookYear = bookOutBookYear( bookOut );
        id = bookOut.getId();
        isReturned = bookOut.getIsReturned();

        BookOutDto bookOutDto = new BookOutDto( id, bookId, bookTitle, bookYear, isReturned );

        return bookOutDto;
    }

    @Override
    public List<BookOutDto> toDtos(List<BookOut> bookOut) {
        if ( bookOut == null ) {
            return null;
        }

        List<BookOutDto> list = new ArrayList<BookOutDto>( bookOut.size() );
        for ( BookOut bookOut1 : bookOut ) {
            list.add( toDto( bookOut1 ) );
        }

        return list;
    }

    @Override
    public void updateEntity(BookOutDto bookOutDto, BookOut bookOut) {
        if ( bookOutDto == null ) {
            return;
        }

        if ( bookOut.getBook() == null ) {
            bookOut.setBook( new Book() );
        }
        bookOutDtoToBook1( bookOutDto, bookOut.getBook() );
        if ( bookOutDto.getId() != null ) {
            bookOut.setId( bookOutDto.getId() );
        }
        if ( bookOutDto.getIsReturned() != null ) {
            bookOut.setIsReturned( bookOutDto.getIsReturned() );
        }
    }

    protected Book bookOutDtoToBook(BookOutDto bookOutDto) {
        if ( bookOutDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookOutDto.getBookId() );
        book.setTitle( bookOutDto.getBookTitle() );
        book.setYear( bookOutDto.getBookYear() );

        return book;
    }

    private Integer bookOutBookId(BookOut bookOut) {
        if ( bookOut == null ) {
            return null;
        }
        Book book = bookOut.getBook();
        if ( book == null ) {
            return null;
        }
        Integer id = book.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String bookOutBookTitle(BookOut bookOut) {
        if ( bookOut == null ) {
            return null;
        }
        Book book = bookOut.getBook();
        if ( book == null ) {
            return null;
        }
        String title = book.getTitle();
        if ( title == null ) {
            return null;
        }
        return title;
    }

    private Integer bookOutBookYear(BookOut bookOut) {
        if ( bookOut == null ) {
            return null;
        }
        Book book = bookOut.getBook();
        if ( book == null ) {
            return null;
        }
        Integer year = book.getYear();
        if ( year == null ) {
            return null;
        }
        return year;
    }

    protected void bookOutDtoToBook1(BookOutDto bookOutDto, Book mappingTarget) {
        if ( bookOutDto == null ) {
            return;
        }

        if ( bookOutDto.getBookId() != null ) {
            mappingTarget.setId( bookOutDto.getBookId() );
        }
        if ( bookOutDto.getBookTitle() != null ) {
            mappingTarget.setTitle( bookOutDto.getBookTitle() );
        }
        if ( bookOutDto.getBookYear() != null ) {
            mappingTarget.setYear( bookOutDto.getBookYear() );
        }
    }
}

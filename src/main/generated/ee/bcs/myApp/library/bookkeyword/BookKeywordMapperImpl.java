package ee.bcs.myApp.library.bookkeyword;

import ee.bcs.myApp.library.book.Book;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-25T15:42:20+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class BookKeywordMapperImpl implements BookKeywordMapper {

    @Override
    public BookKeyword bookKeywordDtoToBookKeyword(BookKeywordDto bookKeywordDto) {
        if ( bookKeywordDto == null ) {
            return null;
        }

        BookKeyword bookKeyword = new BookKeyword();

        bookKeyword.setBook( bookKeywordDtoToBook( bookKeywordDto ) );
        bookKeyword.setId( bookKeywordDto.getId() );

        return bookKeyword;
    }

    @Override
    public BookKeywordDto toDto(BookKeyword bookKeyword) {
        if ( bookKeyword == null ) {
            return null;
        }

        Integer bookId = null;
        String bookTitle = null;
        Integer bookYear = null;
        Integer id = null;

        bookId = bookKeywordBookId( bookKeyword );
        bookTitle = bookKeywordBookTitle( bookKeyword );
        bookYear = bookKeywordBookYear( bookKeyword );
        id = bookKeyword.getId();

        BookKeywordDto bookKeywordDto = new BookKeywordDto( id, bookId, bookTitle, bookYear );

        return bookKeywordDto;
    }

    @Override
    public void updateBookKeywordFromBookKeywordDto(BookKeywordDto bookKeywordDto, BookKeyword bookKeyword) {
        if ( bookKeywordDto == null ) {
            return;
        }

        if ( bookKeyword.getBook() == null ) {
            bookKeyword.setBook( new Book() );
        }
        bookKeywordDtoToBook1( bookKeywordDto, bookKeyword.getBook() );
        if ( bookKeywordDto.getId() != null ) {
            bookKeyword.setId( bookKeywordDto.getId() );
        }
    }

    protected Book bookKeywordDtoToBook(BookKeywordDto bookKeywordDto) {
        if ( bookKeywordDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookKeywordDto.getBookId() );
        book.setTitle( bookKeywordDto.getBookTitle() );
        book.setYear( bookKeywordDto.getBookYear() );

        return book;
    }

    private Integer bookKeywordBookId(BookKeyword bookKeyword) {
        if ( bookKeyword == null ) {
            return null;
        }
        Book book = bookKeyword.getBook();
        if ( book == null ) {
            return null;
        }
        Integer id = book.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String bookKeywordBookTitle(BookKeyword bookKeyword) {
        if ( bookKeyword == null ) {
            return null;
        }
        Book book = bookKeyword.getBook();
        if ( book == null ) {
            return null;
        }
        String title = book.getTitle();
        if ( title == null ) {
            return null;
        }
        return title;
    }

    private Integer bookKeywordBookYear(BookKeyword bookKeyword) {
        if ( bookKeyword == null ) {
            return null;
        }
        Book book = bookKeyword.getBook();
        if ( book == null ) {
            return null;
        }
        Integer year = book.getYear();
        if ( year == null ) {
            return null;
        }
        return year;
    }

    protected void bookKeywordDtoToBook1(BookKeywordDto bookKeywordDto, Book mappingTarget) {
        if ( bookKeywordDto == null ) {
            return;
        }

        if ( bookKeywordDto.getBookId() != null ) {
            mappingTarget.setId( bookKeywordDto.getBookId() );
        }
        if ( bookKeywordDto.getBookTitle() != null ) {
            mappingTarget.setTitle( bookKeywordDto.getBookTitle() );
        }
        if ( bookKeywordDto.getBookYear() != null ) {
            mappingTarget.setYear( bookKeywordDto.getBookYear() );
        }
    }
}

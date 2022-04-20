package ee.bcs.myApp.library.bookkeyword;

import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.keyword.Keyword;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-19T13:27:24+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Amazon.com Inc.)"
)
@Component
public class BookKeywordMapperImpl implements BookKeywordMapper {

    @Override
    public BookKeyword toEntity(BookKeywordDto bookKeywordDto) {
        if ( bookKeywordDto == null ) {
            return null;
        }

        BookKeyword bookKeyword = new BookKeyword();

        bookKeyword.setBook( bookKeywordDtoToBook( bookKeywordDto ) );
        bookKeyword.setKeyword( bookKeywordDtoToKeyword( bookKeywordDto ) );
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
        Integer keywordId = null;
        String keywordName = null;
        Integer id = null;

        bookId = bookKeywordBookId( bookKeyword );
        bookTitle = bookKeywordBookTitle( bookKeyword );
        bookYear = bookKeywordBookYear( bookKeyword );
        keywordId = bookKeywordKeywordId( bookKeyword );
        keywordName = bookKeywordKeywordName( bookKeyword );
        id = bookKeyword.getId();

        BookKeywordDto bookKeywordDto = new BookKeywordDto( id, bookId, bookTitle, bookYear, keywordId, keywordName );

        return bookKeywordDto;
    }

    @Override
    public List<BookKeywordDto> toDtos(List<BookKeyword> bookKeywords) {
        if ( bookKeywords == null ) {
            return null;
        }

        List<BookKeywordDto> list = new ArrayList<BookKeywordDto>( bookKeywords.size() );
        for ( BookKeyword bookKeyword : bookKeywords ) {
            list.add( toDto( bookKeyword ) );
        }

        return list;
    }

    @Override
    public void updateEntity(BookKeywordDto bookKeywordDto, BookKeyword bookKeyword) {
        if ( bookKeywordDto == null ) {
            return;
        }

        if ( bookKeyword.getBook() == null ) {
            bookKeyword.setBook( new Book() );
        }
        bookKeywordDtoToBook1( bookKeywordDto, bookKeyword.getBook() );
        if ( bookKeyword.getKeyword() == null ) {
            bookKeyword.setKeyword( new Keyword() );
        }
        bookKeywordDtoToKeyword1( bookKeywordDto, bookKeyword.getKeyword() );
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

    protected Keyword bookKeywordDtoToKeyword(BookKeywordDto bookKeywordDto) {
        if ( bookKeywordDto == null ) {
            return null;
        }

        Keyword keyword = new Keyword();

        keyword.setId( bookKeywordDto.getKeywordId() );
        keyword.setName( bookKeywordDto.getKeywordName() );

        return keyword;
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

    private Integer bookKeywordKeywordId(BookKeyword bookKeyword) {
        if ( bookKeyword == null ) {
            return null;
        }
        Keyword keyword = bookKeyword.getKeyword();
        if ( keyword == null ) {
            return null;
        }
        Integer id = keyword.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String bookKeywordKeywordName(BookKeyword bookKeyword) {
        if ( bookKeyword == null ) {
            return null;
        }
        Keyword keyword = bookKeyword.getKeyword();
        if ( keyword == null ) {
            return null;
        }
        String name = keyword.getName();
        if ( name == null ) {
            return null;
        }
        return name;
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

    protected void bookKeywordDtoToKeyword1(BookKeywordDto bookKeywordDto, Keyword mappingTarget) {
        if ( bookKeywordDto == null ) {
            return;
        }

        if ( bookKeywordDto.getKeywordId() != null ) {
            mappingTarget.setId( bookKeywordDto.getKeywordId() );
        }
        if ( bookKeywordDto.getKeywordName() != null ) {
            mappingTarget.setName( bookKeywordDto.getKeywordName() );
        }
    }
}

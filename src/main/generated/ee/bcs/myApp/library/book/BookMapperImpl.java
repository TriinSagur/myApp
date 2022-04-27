package ee.bcs.myApp.library.book;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-25T13:58:20+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Amazon.com Inc.)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book bookDtoToBook(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDto.getId() );
        book.setTitle( bookDto.getTitle() );
        book.setYear( bookDto.getYear() );

        return book;
    }

    @Override
    public BookDto bookToBookDto(Book book) {
        if ( book == null ) {
            return null;
        }

        Integer id = null;
        String title = null;
        Integer year = null;

        id = book.getId();
        title = book.getTitle();
        year = book.getYear();

        BookDto bookDto = new BookDto( id, title, year );

        return bookDto;
    }

    @Override
    public void updateBookFromBookDto(BookDto bookDto, Book book) {
        if ( bookDto == null ) {
            return;
        }

        if ( bookDto.getId() != null ) {
            book.setId( bookDto.getId() );
        }
        if ( bookDto.getTitle() != null ) {
            book.setTitle( bookDto.getTitle() );
        }
        if ( bookDto.getYear() != null ) {
            book.setYear( bookDto.getYear() );
        }
    }
}

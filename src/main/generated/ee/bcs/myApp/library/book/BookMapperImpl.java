package ee.bcs.myApp.library.book;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-16T12:22:38+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14 (Amazon.com Inc.)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toEntity(BookDto dto) {
        if ( dto == null ) {
            return null;
        }

        Book book = new Book();

        book.setTitle( dto.getTitle() );
        book.setYear( dto.getYear() );

        return book;
    }

    @Override
    public BookDto toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId( book.getId() );
        bookDto.setTitle( book.getTitle() );
        bookDto.setYear( book.getYear() );

        return bookDto;
    }

    @Override
    public List<BookDto> toDtos(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<BookDto> list = new ArrayList<BookDto>( books.size() );
        for ( Book book : books ) {
            list.add( toDto( book ) );
        }

        return list;
    }

    @Override
    public void updateEntity(BookDto bookDto, Book book) {
        if ( bookDto == null ) {
            return;
        }

        if ( bookDto.getTitle() != null ) {
            book.setTitle( bookDto.getTitle() );
        }
        if ( bookDto.getYear() != null ) {
            book.setYear( bookDto.getYear() );
        }
    }
}

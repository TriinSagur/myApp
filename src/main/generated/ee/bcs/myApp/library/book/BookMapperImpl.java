package ee.bcs.myApp.library.book;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-18T12:01:41+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (JetBrains s.r.o.)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toEntity(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setTitle( bookDto.getTitle() );
        book.setYear( bookDto.getYear() );

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
    public List<BookDto> toDtos(List<Book> entities) {
        if ( entities == null ) {
            return null;
        }

        List<BookDto> list = new ArrayList<BookDto>( entities.size() );
        for ( Book book : entities ) {
            list.add( toDto( book ) );
        }

        return list;
    }

    @Override
    public void updateEntity(BookDto bookDto, Book book) {
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

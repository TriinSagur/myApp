package ee.bcs.myApp.library.author;

import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookDto;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {



    private BookDto toDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setYear(book.getYear());
        return bookDto;
    }

    private Book toEntity(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        return book;
    }
}

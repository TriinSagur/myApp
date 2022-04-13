package ee.bcs.myApp.library.book;

import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service

public class BookService {

    @PostMapping("/add")
    @Operation(summary = "lisab uue raamatu")

    public Integer addNewBook(@RequestBody BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthors(bookDto.getAuthors());
        book.setYear(bookDto.getYear());
   //     book.upDateId();

        return book.getId();

    }
/*    public Book findBookByTitle(@RequestParam String title) {
        List<Book> books = Library();*/

 /*   public Book findBookByAuthors(@RequestParam String author) {
    }*/
}


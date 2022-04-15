package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.author.AuthorRepository;
import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookDto;
import ee.bcs.myApp.library.book.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book-author")
public class BookAuthorController {


   @Resource
   private BookAuthorService bookAuthorService;


    @PostMapping
    @Operation(summary = "Add author to a book by last name and book title")
    public void addNewBookAuthor(String title, String lastName) {
        bookAuthorService.addNewBookAuthor(title, lastName);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all books with authors")
    public List<BookAuthorDto> getAllBookAuthors() {
        return bookAuthorService.getAllBookAuthors();
    }

    @GetMapping("/id")
    @Operation(summary = "Find book and author by Id")
    public BookAuthorDto findBookAuthorById(@RequestParam Integer id) {
        return bookAuthorService.findBookAuthorById(id);
    }
}

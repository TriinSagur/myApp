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
    private AuthorRepository authorRepository;

    @Resource
    private BookRepository bookRepository;

    @Resource
    private BookAuthorRepository bookAuthorRepository;

    @Resource
    private BookAuthorService bookAuthorService;

    @GetMapping("/demo")
    public void demo1() {
        bookAuthorService.demo1();
    }

    @PutMapping
    @Operation(summary = "Lisab uue seose raamatu ja autori vahel.")
    public BookAuthorDto addNewBookAuthorConnection(@RequestParam Integer bookId, @RequestParam Integer authorId) {
        return bookAuthorService.addNewBookAuthorConnection(bookId, authorId);
    }

    @PutMapping("/add")
    @Operation(summary = "Lisab uue raamat-autor komplekti.")
    public BookAuthorDto addNewBookAuthor1(@RequestBody BookAuthorDto bookAuthorDto) {
        return bookAuthorService.addNewBookAuthor1(bookAuthorDto);
    }

    @GetMapping
    @Operation(summary = "Tagastab kõik raamat-autor komplektid.")
    public List<BookAuthorDto> getAllBookAuthors() {
        return bookAuthorService.getAllBookAuthors();
    }

    @DeleteMapping
    @Operation(summary = "Kustutab andmebaasi id järgi raamat-autor seose.")
    public void removeBookAuthorById(@RequestParam Integer id) {
        bookAuthorService.removeBookAuthorById(id);
    }

    @PutMapping("/update")
    @Operation(summary = "Uuendab raamat-autor seost.")
    public BookAuthorDto updateBookAuthorById(@RequestParam Integer id, @RequestBody BookAuthorDto bookAuthorDto) {
        return bookAuthorService.updateBookAuthorById(id, bookAuthorDto);
    }
//    @GetMapping("/author")
//    @Operation(summary = "Tagastab autori kõik raamatud.")
//    public List<Book> getAllAuthorBooks(@RequestParam Integer id) {
//        return authorService.getAllAuthorBooks(id);
//    }
}

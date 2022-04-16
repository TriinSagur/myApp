package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.author.AuthorRepository;
import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookDto;
import ee.bcs.myApp.library.book.BookRepository;
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
    public BookAuthorDto addNewBookAuthorConnection(@RequestParam Integer bookId, @RequestParam Integer authorId) {
        return bookAuthorService.addNewBookAuthorConnection(bookId,authorId);
    }

    @PutMapping("/add")
    public BookAuthorDto addNewBookAuthor1(@RequestBody BookAuthorDto bookAuthorDto) {
        return bookAuthorService.addNewBookAuthor1(bookAuthorDto);
    }

    @GetMapping
    public List<BookAuthorDto> getAllBookAuthors() {
        return bookAuthorService.getAllBookAuthors();
    }



}

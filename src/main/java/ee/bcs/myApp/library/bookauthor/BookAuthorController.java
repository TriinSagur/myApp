package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.author.AuthorRepository;
import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/book-author")
public class BookAuthorController {

    @Resource
    private BookAuthorService bookAuthorService;

    @Resource
    private AuthorRepository authorRepository;

    @Resource
    private BookRepository bookRepository;

    @Resource
    private BookAuthorRepository bookAuthorRepository;


    @GetMapping
    public void demo() {
        Author author = authorRepository.getByLastName("Banderas");
        Book book = bookRepository.findByTitle("Harry Potter");
        BookAuthor bookAuthor = new BookAuthor();
        bookAuthor.setAuthor(author);
        bookAuthor.setBook(book);
        bookAuthorRepository.save(bookAuthor);
    }

    @PostMapping("/book-and-author")
    @Operation(summary = "lisab raamatu ja autori samaaegselt")
    public void addBookAndAuthor(@RequestBody BookAuthorDto bookAuthorDto) {
        bookAuthorService.addBookAndAuthor(bookAuthorDto);
    }


}

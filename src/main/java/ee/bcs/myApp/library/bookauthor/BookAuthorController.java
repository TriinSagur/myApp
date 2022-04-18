package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.AuthorRepository;
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

    @Resource         // peaks tegema service kalssi
    private AuthorRepository authorRepository;

    @Resource         // peaks tegema service kalssi
    private BookRepository bookRepository;

    @Resource         // peaks tegema service kalssi
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
    @Operation
    public void addBookAndAuthor(@RequestBody BookAuthorDto bookAuthorDto) {
        bookAuthorService.addBookAndAuthor(bookAuthorDto);
    }
}

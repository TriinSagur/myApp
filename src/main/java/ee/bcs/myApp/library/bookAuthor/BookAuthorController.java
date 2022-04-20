package ee.bcs.myApp.library.bookAuthor;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.author.AuthorRepository;
import ee.bcs.myApp.library.book.BookRepository;
import ee.bcs.myApp.library.bookAuthor.BookAuthorDto;
import ee.bcs.myApp.library.bookAuthor.BookAuthorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/book-author")
public class BookAuthorController {

    private BookAuthorService bookAuthorService;

    @Resource
    private AuthorRepository authorRepository;


    @Resource
    private BookRepository bookRepository;


//    @Resource
//    private BookAuthorRepository bookAuthorRepository;
//
//
//
//    @GetMapping
//    public void demo1() {
//        Author author = authorRepository.getByLastName("Banderas");
//        Book book = bookRepository.findByTitle("Harry Potter");
//        BookAuthor bookAuthor = new BookAuthor();
//        bookAuthor.setAuthor(author);
//        bookAuthor.setBook(book);
//        bookAuthorRepository.save(bookAuthor);
//
//
//    }

    @PostMapping("/book-and-author")
    @Operation(summary = "Lisab samaaegselt uue raamatu ja autori")
    public void addBookAndAuthor(@RequestBody BookAuthorDto bookAuthorDto) {
//        bookAuthorService.addBookAndAuthor(bookAuthorDto);

    }

}
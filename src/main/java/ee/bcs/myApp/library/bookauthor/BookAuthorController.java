package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.author.AuthorRepository;
import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookRepository;
import ee.bcs.myApp.library.keyword.KeywordDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book-author")
public class BookAuthorController {

//    @Resource
//    private AuthorRepository authorRepository;
//
//    @Resource
//    private BookRepository bookRepository;

    @Resource
    private BookAuthorRepository bookAuthorRepository;

    @Resource
    private BookAuthorService bookAuthorService;


    @GetMapping("/all")
    @Operation(summary = "Kuvab kõik bookAuthorid")
    public List<BookAuthorDto> findAllBookAuthors() {
        return bookAuthorService.findAllBookAuthors();
    }

    @GetMapping("/id")
    @Operation(summary = "Leiab bookauthori id järgi")
    public BookAuthorDto findById(@RequestParam Integer id) {
        return bookAuthorService.findById(id);
    }

    @PostMapping("/new")
    @Operation(summary = "Lisab uue bookAuthori lastName ja titel järgi")
    public void addNew(@RequestParam String title, @RequestParam String lastName) {
        bookAuthorService.addNew(title,lastName);
    }

    @PutMapping()
    @Operation(summary = "uuendab bookAuthorit")
    public void updateBookauthord () {

    }




//    @GetMapping
//    public void demo1() {
//        bookAuthorService.demo1();
//    }

}

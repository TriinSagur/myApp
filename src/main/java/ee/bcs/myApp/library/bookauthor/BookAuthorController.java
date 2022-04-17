package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.AuthorDto;
import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book-author")
public class BookAuthorController {

    @Resource
    private BookAuthorService bookAuthorService;


    @PostMapping("/addnew")
    @Operation(summary = "lisab uue book-autori")
    public BookAuthorDto addNewBookAuthor(@RequestParam Integer bookId, @RequestParam Integer authorId) {
        return bookAuthorService.addNewBookAuthor(bookId,authorId);
    }

//    @PostMapping("/addnewbook")
//    @Operation(summary = "lisab uue book-autori")
//    public void addNewBookAndAuthor(@RequestBody AuthorDto authorDto, @RequestBody BookDto bookDto) {
//        bookAuthorService.addNewBookAndAuthor(authorDto, bookDto);
//    }

    @GetMapping("/all")
    @Operation(summary = "leiab koik book-autoreid")
    public List<BookAuthorDto> findAllBookAuthors() {
        return bookAuthorService.findAllBookAuthors();


    }

}

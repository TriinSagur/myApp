package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.AuthorDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book-author")
public class BookAuthorController {


   @Resource
   private BookAuthorService bookAuthorService;


    @PostMapping
    @Operation(summary = "Lisa raamatu autori")
    public void addNewBookAuthor(String title, String lastName) {
        bookAuthorService.addNewBookAuthor(title, lastName);
    }

    @GetMapping("/all")
    @Operation(summary = "Näita kõik raamatu autorid")
    public List<BookAuthorDto> getAllBookAuthors() {
        return bookAuthorService.getAllBookAuthors();
    }

    @GetMapping("/id")
    @Operation(summary = "Find book author by ID")
    public BookAuthorDto findBookAuthorById(@RequestParam Integer id) {
        return bookAuthorService.findBookAuthorById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Delete Book and Author by ID")
    public void removeBookAuthorById(Integer id) {
        bookAuthorService.removeBookAuthorById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Update Book and Author by ID")
    public void updateBookAuthorById(@RequestParam Integer id,@RequestParam String title,@RequestParam String lastName) {
        bookAuthorService.updateBookAuthor(id, title, lastName);
    }

    @GetMapping("/last-name")
    @Operation(summary = "find all books by author last name")
    public List<BookAuthorDto> getAllBooksByAuthor(@RequestParam String lastName) {
        return bookAuthorService.getAllBooksByAuthor(lastName);
    }
    @GetMapping("/title")
    @Operation(summary = "find all authors by book title")
    public List<BookAuthorDto> getAllAuthorsByTitle(@RequestParam String title) {
        return bookAuthorService.getAllAuthorsByTitle(title);
    }


}

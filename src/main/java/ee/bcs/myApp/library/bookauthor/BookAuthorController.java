package ee.bcs.myApp.library.bookauthor;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bookAuthor")
public class BookAuthorController {

    @Resource
    private BookAuthorService bookAuthorService;

    @GetMapping("/all")
    @Operation(summary = "Tagastab kõik raamtute ja autorite vahelised seosed")
    public List<BookAuthorDto> getAllBookAuthors() {
        return bookAuthorService.getAllBookAuthors();
    }

    @GetMapping("/id")
    @Operation(summary = "Tagastab raamatu ja autori vahelise seose id järgi")
    public BookAuthorDto getBookAuthorById(@RequestParam Integer id) {
        return bookAuthorService.getBookAuthorById(id);
    }

    @PostMapping("/new-book-and-author")
    @Operation(summary = "Lisab uue raamatu ja autori")
    public BookAuthorDto addNewBookAndAuthor(@Valid @RequestBody BookAuthorDto bookAuthorDto) {
        return bookAuthorService.addNewBookAndAuthor(bookAuthorDto);
    }

    @PutMapping ("/update-bookAuthor-connection")
    @Operation(summary = "Lisab/uuendab uue autori ja raamatu vahelise seose")
    public void addBookAndAuthorConnection(@RequestParam Integer authorId, @RequestParam Integer bookId) {
        bookAuthorService.addBookAndAuthorConnection(authorId, bookId);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "kustutab raamatu ja autori seose")
    public void deleteBookAuthor(@RequestParam Integer id) {
        bookAuthorService.deleteBookAuthor(id);
    }
}

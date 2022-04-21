package ee.bcs.myApp.library.bookauthor;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book-author")
public class BookAuthorController {

    @Resource
    private BookAuthorService bookAuthorService;

    @PostMapping("/book-and-author")
    @Operation(summary = "Lisab uue raamatu ja uue autori samaaegselt")
    public void addBookAndAuthor(@RequestBody AddBookAuthorDto bookAuthorDto ) {
        bookAuthorService.addBookAndAuthor(bookAuthorDto);
    }

    @DeleteMapping("/")
    @Operation(summary = "Kustutab bookauthori")
    public void addAuthorToBook(@RequestParam Integer bookAuthorId) {
        bookAuthorService.deleteBookAuthorById(bookAuthorId);
    }
    @PutMapping("/")
    @Operation(summary = "Lisab olemasolevale raamatule olemasoleva autori")
    public void addAuthorToBook(@RequestBody AddAuthorToBook authorToBook) {
        bookAuthorService.addAuthorToBook(authorToBook);
    }

}

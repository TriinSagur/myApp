package ee.bcs.myApp.library.bookauthor;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book-author")
public class BookAuthorController {

    @Resource
    private ee.bcs.myApp.library.bookauthor.BookAuthorService bookAuthorService;

    @PostMapping("/book-and-author")
    @Operation(summary = "Lisab samaaegselt uue raamatu ja uue autori")
    public void addBookAndAuthor(@RequestBody BookAuthorDto bookAuthorDto) {
        bookAuthorService.addBookAndAuthor(bookAuthorDto);
    }

    @PutMapping("/connect")
    @Operation(summary = "Loob seose autori ja raamatu vahel")
    public void connectBookWithAuthor(@RequestParam String lastName, @RequestParam String bookName) {
        bookAuthorService.connectBookWithAuthor(lastName, bookName);
    }

    @GetMapping("/all")
    @Operation(summary = "Tagastab kõik raamatud koos autoriga")
    public List<BookAuthorDto> getAllBooksAndAuthors() {
        return bookAuthorService.getAllBooksAndAuthors();
    }

    @GetMapping("/id")
    @Operation(summary = "Tagastab autori ja raamatu andmebaasi id järgi")
    public BookAuthorDto findBookAuthorById(Integer id) {
        return bookAuthorService.findBookAuthorById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Kustutab autori ja raamatu andmebaasi id järgi")
    public void deleteBookAndAuthor(@RequestParam Integer id) {
         bookAuthorService.deleteBookAndAuthor(id);
    }




}

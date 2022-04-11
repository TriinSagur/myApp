package ee.bcs.myApp.library;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Resource
    private BookService bookService;

    @PostMapping
    @Operation(summary = "Lisab uue raamatu")
    public Integer addNewBook(@RequestBody BookDto bookDto) {
        return bookService.addNewBook(bookDto);
    }


    @GetMapping("/all")
    @Operation(summary = "Kogu list")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/id")
    @Operation(summary = "Leiab andmebaasi id järgi raamatu.")
    public Book findBookById(@RequestParam Integer id) {
        return bookService.findBookById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Kustutab andmebaasi id järgi raamatu.")
    public void removeBookById(@RequestParam Integer id) {
        bookService.removeBookById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Uuendab andmebaasi id järgi raamatut.")
    public void updateBookById(@RequestParam Integer id, @RequestBody BookDto bookDto) {
        bookService.updateBookById(id, bookDto);
    }

}

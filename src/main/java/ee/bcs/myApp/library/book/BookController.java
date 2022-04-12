package ee.bcs.myApp.library.book;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Resource
    private BookService bookService;

    @PostMapping
    @Operation(summary = "Lisab uue raamatu")
    private BookDto addNewBook(@Valid @RequestBody BookDto bookDto) {
        return bookService.addNewBook(bookDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Tagastab kõik raamatud")
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/id")
    @Operation(summary = "Leiab andmebaasi ID järgi raamatu")
    public BookDto findBookById(@RequestParam Integer id) {
        return bookService.findBookById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Eemaldab raamatu id järgi")
    public void removeBookById(@RequestParam Integer id) {
        bookService.removeBookById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Uuendab andmebaasi id järgi raamatu")
    private void updateBookById(@RequestParam Integer id, @Valid @RequestBody BookDto bookDto) {
        bookService.updateBookById(id, bookDto);
    }
}

package ee.bcs.myApp.library.book;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    public List<BookDto> findAllBooks() {

        return bookService.findAllBooks();
    }

    @PostMapping
    @Operation(summary = "Uue raamatu lisamine")
    public Integer addNewBook(@Valid @RequestBody BookDto bookDto) {
        return bookService.addNewBook(bookDto);

    }

    @GetMapping
    @Operation(summary = "Leiab andmebaasi ID jargi raamatu")
    public Book findBookById(@RequestParam Integer id) {
        return bookService.findBookById(id);
    }

    @DeleteMapping
    @Operation(summary = "Kustutab raamatu nimekirjast")
    public void removeBookById (@RequestParam Integer id) {
        bookService.removeBookById(id);
    }
}

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

    @GetMapping("/all")
    @Operation(summary = "leib kõik raamatud")
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/titel")
    @Operation(summary = "leiab raamtu pealkirja järgi")
    public BookDto getBookByTitel(@RequestParam String titel) {
        return bookService.getBookByTitel(titel);
    }

    @PostMapping("/add")
    @Operation(summary = "lisab uue raamatu")
    public BookDto addNewBook(@Valid @RequestBody BookDto bookDto) {
        return bookService.addNewBook(bookDto);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Kustutab raamatu id järgi")
    public void deleteBookById(@RequestParam Integer id) {
        bookService.deleteBookById(id);
    }

    @PutMapping("/update")
    @Operation(summary = "Uuendab raamatud ID järgi")
    public void updateBookByTitle(String titel, BookDto bookDto) {
        bookService.updateBookByTitle(titel, bookDto);
    }

}

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
    @Operation(summary = "Uue raamatu lisamine")
    public BookDto addNewBook(@Valid @RequestBody BookDto bookDto) {
        return bookService.addNewBook(bookDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Näita kõik raamatuid")
    public List<BookDto> findAllBooks() {
        return bookService.findAllBooks();
    }

    @DeleteMapping
    @Operation(summary = "Delete the book from the list")
    public void removeBookById(@RequestParam Integer id) {
        bookService.removeBookById(id);
    }

    @GetMapping("/id")
    @Operation(summary = "Leiab andmebaasi ID jargi raamatu")
    public BookDto findBookById(@RequestParam Integer id) {
        return bookService.findBookById(id);
    }

    @PutMapping
    @Operation(summary = "Update book by ID")
    public void updateById(@RequestParam Integer id, @RequestBody BookDto bookDto) {
        bookService.updateById(id, bookDto);
    }
}

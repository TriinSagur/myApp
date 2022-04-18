package ee.bcs.myApp.library.book;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Resource
    private BookService bookService;

    @PostMapping("/add")
    @Operation(summary = "Lisab raamatu")
    public BookDto addNewBook(@RequestBody BookDto bookDto) {
        return bookService.addNewBook(bookDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Kuvab kõik raamatud")
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/id")
    @Operation(summary = "Leiab raamatu ID kaudu")
    public BookDto findBookById(@RequestParam Integer id) {
        return bookService.findBookById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Eemaldab raamatu ID kaudu")
    public void removeBookById(@RequestParam Integer id) {
        bookService.removeBookById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Muudab raamatu sissekannet ID kaudu")
    public void updateBookById(@RequestParam Integer id, @RequestBody BookDto bookDto) {
        bookService.updateBookById(id, bookDto);
    }
}

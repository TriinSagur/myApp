package ee.bcs.myApp.library;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Resource
    private BookService bookService;

    @PostMapping("/id")
    @Operation(summary = "Lisab raamatu")
    public Integer addNewBook(@RequestBody BookDto bookDto) {
        return bookService.addNewBook(bookDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Kuvab kõik raamatud")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/id")
    @Operation(summary = "Leiab raamatu ID kaudu")
    public Book findBookById(@RequestParam Integer id) {
        return bookService.findBookById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Eemaldab raamatu ID järgi")
    public void removeBookById(@RequestParam Integer id) {
        bookService.removeBookById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Muudab raamatu sissekannet ID kaudu")
    public void updateBookById(@RequestParam Integer id, @RequestBody BookDto bookDto) {
        bookService.updateBookById(id, bookDto);
    }
}

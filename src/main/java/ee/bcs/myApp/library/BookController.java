package ee.bcs.myApp.library;

import ee.bcs.myApp.MyAppApplication;
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
    @Operation(summary = "Tagastab kõik raamatud")
    public List getAllBooks() {
        return MyAppApplication.libraryRepository.getBooks();
    }

    @GetMapping("/id")
    @Operation (summary = "Leiab raamatu id järgi")
    public Book findBookById(@RequestParam Integer id) {
        return bookService.findBookById(id);
    }

    @DeleteMapping("/id")
    @Operation (summary = "Kustutab raamatu id järgi")
    public void removeBookById(@RequestParam Integer id) {
        bookService.removeBookById(id);
    }

    @PutMapping("/id")
    @Operation (summary = "Uuendab raamatu id ja uute andmete järgi")
    public void updateBookById(@RequestParam Integer id,@RequestBody BookDto bookDto) {
        bookService.updateBookById(id, bookDto);
    }

}

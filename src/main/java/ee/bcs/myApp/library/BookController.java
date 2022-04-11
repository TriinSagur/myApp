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
    @Operation(summary = "Tagastab kõik raamatud.")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/id")
    @Operation(summary = "Tagastab raamatu andmebaasi ID järgi.")
    public BookDto findBookById(@RequestParam Integer id) {
        return bookService.findBookById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Kustutab raamatu andmebaasi ID järgi.")
    public void deleteBookById(@RequestParam Integer id) {
        bookService.deleteBookById(id);
    }

    @PutMapping("/id")
    @Operation(summary="Muudab raamatu andmeid andmebaasi ID järgi.")
    public void changeBookById(@RequestParam Integer id, @RequestBody BookDto bookDto){
        bookService.changeBookById(id, bookDto);
    }
}

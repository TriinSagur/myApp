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




    @PostMapping("/new")
    @Operation(summary = "Lisab uue raamatu")
    public BookDto addNewBook(@Valid @RequestBody BookDto bookDto) {
        return bookService.addNewBook(bookDto);
    }

    @GetMapping("/id")
    @Operation(summary = "otsib raamatu Id jargi")
    public BookDto findBookById(@RequestParam Integer id) {
        return bookService.findBookById(id);
    }

    @GetMapping("/all")
    @Operation(summary = "otsib koik raamatud")
    public List<BookDto> findAllBooks() {
        return bookService.findAllBooks();
    }

    @PutMapping("/id")
    @Operation(summary = "uuendab raamatu andmeid")
    public void updateBookById(@RequestParam Integer id, @Valid @RequestBody BookDto bookDto) {
        bookService.updateBookById(id, bookDto);
    }


    @DeleteMapping("/id")
    @Operation(summary = "kustutab raamatu id jargi")
    public String removeBookById(@RequestParam Integer id) {
        return bookService.removeBookById(id);

    }

    @DeleteMapping ("/title")
    @Operation(summary = "kustutab raamatu nime jargi")
    public String removeBookByTitle (@RequestParam String title) {
        return bookService.removeBookByTitle(title);
    }
}

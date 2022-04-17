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


    @PostMapping("/all")
    @Operation(summary = "Lisab uue raamatu")
    public BookDto addNewBook(@RequestBody BookDto bookDto) {
        return bookService.addNewBook(bookDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Tagastab raamatute nimekirja.")
    public List<BookDto> getAllBooks() {

        return bookService.returnAllBooks();
    }

    @GetMapping(("/id"))
    @Operation(summary = "Leiab raamatu id alusel.")
    public BookDto findBookById(@RequestParam Integer id) {
        return bookService.findBookById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Kustutab ID järgi kliendi")
    public void removeBookById(@RequestParam Integer id) {

        bookService.removeBookById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Uuendab klienti ID järgi")
    public void updateBookById(@RequestParam Integer id, @Valid @RequestBody BookDto bookDto) {
        bookService.updateBookById(id, bookDto);
    }

//    @PutMapping("/rental")
//    @Operation(summary = "laenutan raamatu")
//    public void bookRent(@RequestParam String firstName, @RequestParam String lastName ) {
//        bookService.bookRentByName(firstName, lastName);
//    }

}

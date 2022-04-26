package ee.bcs.myApp.library.book;

import ee.bcs.myApp.MyAppApplication;
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
    @Operation(summary = " lisab uue raamatu")                                  // ei tööta
    public BookDto addNewBook(@Valid @RequestBody BookDto bookDto) {
        return bookService.addNewBook(bookDto);
    }

    @GetMapping("/all")
    @Operation(summary = "tagastab kõik raamatud")
    public List<BookDto> getAllBooks() {

         return bookService.getAllBooks();

    }

    @GetMapping("/id")
    @Operation(summary = "otsib andmebaasi ID järgi raamatu")
    public BookDto findBookById(@RequestParam Integer id) {
        return bookService.findBookById(id);
    }

    @GetMapping("/year")
    @Operation(summary = "leiab raamatu aasta järgi")                                   // ei tööta
    public BookDto findBookByYear(@RequestParam Integer year) {
        return bookService.findBookByYear(year);
    }

    @GetMapping("/year2")
    @Operation(summary = "leiab väljaandmise aasta järgi raamatud")                 // ei tööta
    public List<BookDto> findBooksByYear(@RequestParam Integer year) {
        return bookService.findBooksByYear(year);
    }

    @DeleteMapping("/id")
    @Operation(summary = "kustutab raamatu andmebaasi ID järgi")   //  see töötaB
    public void removeBookById(@RequestParam Integer id) {
        bookService.removeBookById(id);
    }
}

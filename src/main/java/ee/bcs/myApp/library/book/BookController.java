package ee.bcs.myApp.library.book;

import ee.bcs.myApp.MyAppApplication;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/book")
@RestController
public class BookController {

    @Resource
    private BookService bookService;

    @PostMapping
    @Operation(summary= "/Lisab uue raamatu")
    public Integer addNewBook(@RequestBody BookDto bookDto) {
        Integer result = bookService.addNewBook(bookDto);
        return bookService.addNewBook(bookDto);
    }

    @GetMapping("/all")
    @Operation(summary = "/Leiab kõik raamatud" )
    public List getAllBooks() {

        return MyAppApplication.libraryRepository.getBooks();


    }
    @DeleteMapping
    @Operation(summary = "Kustutab raamatu")
    public Integer removeBook() {
        return null;

    }

    // kustutama
    //muutma
    // kõik raamatud välja ja üks haaval



}

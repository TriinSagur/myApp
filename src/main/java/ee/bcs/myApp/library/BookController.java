package ee.bcs.myApp.library;

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
    @Operation(summary = " lisab uue raamatu")
    public Integer addNewBook(@Valid @RequestBody BookDto bookDto) {
        return bookService.addNewBook(bookDto);
    }

    @GetMapping("/all")
    @Operation(summary = "tagastab kõik raamatud")
    public List<Book> getAllBooks() {

        // return bookService.getClass();
       return MyAppApplication.libraryRepository.getBooks();
    }

}

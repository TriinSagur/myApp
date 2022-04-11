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

        return BookService.addNewBook(bookDto);
    }

    @GetMapping ("/all")
    @Operation(summary = "Tagastab kõik raamatud")
    public List getAllBooks() {

        return MyAppApplication.libraryRepository.getBooks();
    }

//    public Book findBookById(Integer id) {
//
//        return BookService.findBookById(id);
//    }

}

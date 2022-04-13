//package ee.bcs.myApp.library.book;
//
//
//import io.swagger.v3.oas.annotations.Operation;
//import org.springframework.web.bind.annotation.*;
//
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@RestController
//@RequestMapping("/book")
//public class BookController {
//
//    @Resource
//    private BookService bookService;
//
//    @PostMapping
//    @Operation(summary = "Lisab uue raamatu")
//    public BookDto addNewBook(@RequestBody BookDto bookDto) {
//
//        return bookService.addNewBook(bookDto);
//    }
//
//    @GetMapping("/all")
//    @Operation(summary = "Tagastab raamatute nimekirja.")
//    public List<BookDto> getAllBooks() {
//
//        return bookService.returnAllBooks();
//    }
//
//    @GetMapping(("/"))
//    @Operation(summary = "Leiab raamatu id alusel.")
//    public Book findBookById(@RequestParam Integer id) {
//        return bookService.findBookEntityById(id);
//    }
//
//    @DeleteMapping("/id")
//    @Operation(summary = "Võtab raamatukogust raamatu  id alusel")
//    public void removeBookById(@RequestParam Integer id) {
//        bookService.removeBookById(id);
//    }
//
//    @DeleteMapping("/name")
//    @Operation(summary = "Võtab raamatukogust raamatu nime alusel")
//    public void removeBookByName(@RequestParam String title) {
//        bookService.removeBookByName(title);
//    }
//
//
//}

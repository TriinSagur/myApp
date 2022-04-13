//package ee.bcs.myApp.library.book;
//
//import io.swagger.v3.oas.annotations.Operation;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("/book")
//public class BookController {
//
//    @Resource
//    private BookService bookService;
//
//    @PostMapping()
//    @Operation(summary = "Lisab uue raamatu")
//    public BookDto addNewBook(@RequestBody @Valid BookDto bookDto) {
//        return bookService.addNewBook(bookDto);
//    }
//
//    @GetMapping("/id")
//    @Operation(summary = "Otsib raamatu ID järgi")
//    public BookDto findBookById(@RequestParam Integer id) {
//        return bookService.findBookById(id);
//    }
//
//    @GetMapping("/all")
//    @Operation(summary = "Kuvab kõik raamatud")
//    public List<BookDto> getAllBooks() {
//       return bookService.getAllBooks();
//    }
//
//
//    @PutMapping("/id")
//    @Operation(summary = "Uuendab raamatu andmeid ID järgi")
//    public void updateBookById(@RequestParam Integer id,@RequestBody BookDto bookDto) {
//        bookService.updateBookById(id, bookDto);
//    }
//
//
//    @DeleteMapping("/id")
//    @Operation(summary = "Kustutab raamatu ID järgi")
//    public void removeBookById (@RequestParam Integer id) {
//        bookService.removeBookById(id);
//    }
//}

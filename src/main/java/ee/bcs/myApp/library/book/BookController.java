//package ee.bcs.myApp.library.book;
//
//import io.swagger.v3.oas.annotations.Operation;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@RestController
//public class BookController {
//
//    @Resource
//    private BookService bookService;
//
//    @PostMapping
//    @Operation(summary = "Lisab uue raamatu.")
//    public BookDto addNewBook(@RequestBody BookDto bookDto) {
//        return bookService.addNewBook(bookDto);
//    }
//
//    @GetMapping("/id")
//    @Operation(summary = "Leiab raamatu andmebaasi ID järgi.")
//    public Book findBookById(@RequestParam Integer id) {
//        return bookService.findBookById(id);
//    }
//
//    @DeleteMapping("/id")
//    @Operation(summary = "Kustutab raamatu andmebaasi ID järgi.")
//    public void removeBookById(@RequestParam Integer id) {
//        bookService.removeBookById(id);
//    }
//
//    @PutMapping("/id")
//    @Operation(summary = "Uuendab raamatu andmebaasi ID järgi.")
//    public void updateBookById(@RequestParam Integer id, @RequestBody BookDto bookDto) {
//        bookService.updateBookById(id, bookDto);
//    }
//}

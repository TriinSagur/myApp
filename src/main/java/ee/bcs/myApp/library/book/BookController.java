//package ee.bcs.myApp.library.book;
//
//
//import io.swagger.v3.oas.annotations.Operation;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/book")
//public class BookController {
//
//    @Resource
//    private BookService bookService;
//
//    @PostMapping
//    @Operation(summary = "Lisab uue raamatu. ")
//    public Integer addNewBook(@Valid @RequestBody BookDto bookDto) {
//        return bookService.addNewBook(bookDto);
//    }
//
//
//}

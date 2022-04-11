//package ee.bcs.myApp.library;
//
//
//import io.swagger.v3.oas.annotations.Operation;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@RestController
//@RequestMapping("/books")
//public class LibraryController {
//
//    @Resource
//    private LibraryService libraryService;
//
//    @PostMapping("/id")
//    @Operation(summary = "Lisab raamatu")
//    public Integer addNewBook(@RequestBody BookDto bookDto) {
//        return libraryService.addNewBook(bookDto);
//    }
//
//    @PostMapping("/all")
//    public List<Book> getAllBooks(){
//        return libraryService.getAllBooks();
//    }
////
////    public Integer getBookById(Integer id) {
////
////    }
//
//}

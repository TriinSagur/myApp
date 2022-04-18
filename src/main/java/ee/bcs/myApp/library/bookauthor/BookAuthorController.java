package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.book.NewBookRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book-author")
public class BookAuthorController {

    @Resource
    private BookAuthorService bookAuthorService;

////    @GetMapping("/demo")
////    public void demo1() {
////        bookAuthorService.demo1();
////    }

    @PostMapping("/addnew")
    @Operation(summary = "lisab uue book-autori")
    public BookAuthorDto addNewBookAuthor(@RequestParam Integer bookId, @RequestParam Integer authorId) {
        return bookAuthorService.addNewBookAuthor(bookId,authorId);
    }


//    @PostMapping("/addnewbook")
//    @Operation(summary = "lisab uue raamatu ja autori *m]lemad korraga, autor on ka uus")
//    public void addNewBookAndAuthor(@RequestBody NewBookRequest newBookRequest) {
////        bookAuthorService.addNewBookAndAuthor(bookDto);
////    TODO: kas korraga ei saa kasutada kaks Dto klassi?
//    }

    @GetMapping("/all")
    @Operation(summary = "leiab koik book-autoreid")
    public List<BookAuthorDto> findAllBookAuthors() {
        return bookAuthorService.findAllBookAuthors();
    }

    @GetMapping("/bytitle")
    @Operation(summary = "leiab book-autori raamatu titli jargi")
    public BookAuthorDto findByBookTitle(@RequestParam String bookTitle) {
        return bookAuthorService.findByBookTitle(bookTitle);
    }

    @GetMapping("/allbooksbylastname")
    @Operation(summary = "leiab koik raamatud autori perekonnanime jargi")
    public List<BookAuthorDto> findAllBooksByLastName(@RequestParam String lastName) {
        return bookAuthorService.findAllBooksByLastName(lastName);
    }

    @DeleteMapping("/removebyid")
    @Operation(summary = "kustutab book-autori id jargi")
    public void removeById(@RequestParam Integer id) {
        bookAuthorService.removeById(id);
    }

    @PutMapping("/updatebookauthorbyid")
    @Operation(summary = "uuendab book-autori id jargi")
    public BookAuthorDto updateById(@RequestBody BookAuthorDto bookAuthorDto, @RequestParam Integer id) {
        return bookAuthorService.updateById(bookAuthorDto, id);
    }

    @PostMapping("/book-and-author")
    @Operation(summary = "lisab uue raamatu ja autori korraga")
    public void addBookAndAuthor(@RequestBody BookAuthorDto bookAuthorDto) {
        bookAuthorService.addBookAndAuthor(bookAuthorDto);
    }
}

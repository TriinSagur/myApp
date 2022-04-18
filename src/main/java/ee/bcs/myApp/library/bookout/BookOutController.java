package ee.bcs.myApp.library.bookout;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book-out")
public class BookOutController {

    @Resource
    private BookOutService bookOutService;

    @PostMapping
    @Operation (summary = "Add book to loan list")
    public BookOutDto addBookById(@RequestParam Integer id) {
        return bookOutService.addBookById(id);
    }

    @PutMapping("/out")
    @Operation(summary = "Change book status to loaned out")
    public BookOutDto loanBook(@RequestParam Integer id) {
        return bookOutService.loanBook(id);
    }

    @PutMapping
    @Operation(summary = "Loan out a book")
    public BookOutDto loanOutBook(@RequestParam Integer id) {
        return bookOutService.loanOutBook(id);
    }

//    @PutMapping("/in")
//    @Operation(summary = "Change book status to returned")
//    public BookOutDto returnBook(@RequestParam Integer id) {
//        return bookOutService.returnBook(id);
//    }

    @GetMapping("/all")
    @Operation(summary = "Get status of all books")
    public List<BookOutDto> getAllBookStatus() {
        return bookOutService.getAllBookStatus();
    }

    @GetMapping("/id")
    @Operation(summary = "Get book status by ID")
    public BookOutDto getBookStatusById(@RequestParam Integer id) {
        return bookOutService.getBookStatusById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Remove book by ID")
    public void removeBookById(@RequestParam Integer id) {
        bookOutService.removeBookById(id);
    }



}

package ee.bcs.myApp.library.bookkeyword;

import ee.bcs.myApp.library.bookkeyword.BookKeywordDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book-keyword")
public class BookKeywordController {

    @Resource
    private BookKeywordService bookKeywordService;

    @PostMapping
    @Operation(summary = "Add keyword to a book")
    public void addNewBookKeyword(String title, String keyword) {
        bookKeywordService.addNewBookKeyword(title, keyword);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all books with keywords")
    public List<BookKeywordDto> getAllBookKeywords() {
        return bookKeywordService.getAllBookKeywords();
    }

    @GetMapping("/id")
    @Operation(summary = "Find a book with keyword by ID")
    public BookKeywordDto findBookKeywordById(@RequestParam Integer id) {
        return bookKeywordService.findBookKeywordById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Delete book keyword by ID")
    public void removeBookKeywordById(Integer id) {
        bookKeywordService.removeBookKeywordById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Update book keyword by ID")
    public void updateBookKeywordById(@RequestParam Integer id,@RequestParam String title, @RequestParam String keyword) {
        bookKeywordService.updateBookKeyword(id, title, keyword);
    }

    @GetMapping("/title")
    @Operation(summary = "find all keywords by book title")
    public List<BookKeywordDto> getAllKeywordsByTitle(@RequestParam String title) {
        return bookKeywordService.getAllKeywordsByTitle(title);
    }

    @GetMapping("/keyword")
    @Operation(summary = "find all books by keyword")
    public List<BookKeywordDto> getAllBooksByKeyword(@RequestParam String keyword) {
        return bookKeywordService.getAllBooksByKeyword(keyword);
    }


}

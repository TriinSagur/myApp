package ee.bcs.myApp.library.bookkeyword;

import ee.bcs.myApp.library.book.BookRepository;
import ee.bcs.myApp.library.keyword.KeywordRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/book-keyword")
public class BookKeywordController {
    @Resource
    private BookKeywordService bookKeywordService;

    @PutMapping
    @Operation(summary = "Lisab uue seose võtmesõna ja raamatu vahel.")
    public BookKeywordDto addNewBookKeywordConnection(@RequestParam Integer bookId, @RequestParam Integer keywordId) {
        return bookKeywordService.addNewBookKeywordConnection(bookId, keywordId);
    }

}

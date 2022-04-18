package ee.bcs.myApp.library.service;

import ee.bcs.myApp.library.author.AuthorDto;
import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookDto;
import ee.bcs.myApp.library.bookauthor.BookAuthorResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Resource
    private LibraryService libraryService;

    @GetMapping("/all")
    @Operation (summary = "Tagastab kõik raamatud autoritega.")
    public List <BookAuthorResponse> getAllBookAuthors() {
        return libraryService.getAllBookAuthors();
    }

    @GetMapping("/all-from-author")
    @Operation (summary = "Tagastab kõik ühe autori raamatud")
    public List<BookDto> getAllBooksForAuthor (@RequestParam String lastName) {
        return libraryService.getAllBooksForAuthor(lastName);
    }

}

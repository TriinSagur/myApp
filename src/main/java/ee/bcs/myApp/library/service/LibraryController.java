package ee.bcs.myApp.library.service;

import ee.bcs.myApp.library.book.BookDto;
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
    @Operation(summary = "Tagastab kõik raamatud autoritega.")
    public List<BookAuthorResponse> getAllBooksWithAuthors() {
        return libraryService.getAllBooksWithAuthors();
    }

    @GetMapping("/all-from-author")
    @Operation(summary = "Tagastab kõik ühe autori raamatud")
    public List<BookDto> getAllBooksForAuthor(@RequestParam String lastName) {
        return libraryService.getAllBooksForAuthor(lastName);
    }

    @GetMapping("/find")
    @Operation(summary = "Otsib raamatuid ja autoreid märksõna järgi")
    public List<BookAuthorResponse> getBooksAndAuthorsByWord(@RequestParam String word) {
        return libraryService.getBooksAndAuthorsByWord(word);
    }

    @PostMapping("/book-and-author")
    @Operation(summary = "Lisab uue raamatu ja uue autori samaaegselt")
    public void addBookAndAuthor(@RequestBody BookAuthorRequest bookAuthorDto) {
        libraryService.addBookAndAuthor(bookAuthorDto);
    }

    @DeleteMapping("/")
    @Operation(summary = "Kustutab autori ja raamatu vahelise seose")
    public void removeAuthorFromBook(@RequestParam Integer bookAuthorId) {
        libraryService.removeAuthorFromBook(bookAuthorId);
    }

    @PutMapping("/")
    @Operation(summary = "Lisab olemasolevale raamatule olemasoleva autori")
    public void addAuthorToBook(@RequestParam Integer bookId,@RequestParam Integer authorId) {
        libraryService.addAuthorToBook(bookId,authorId);
    }

}

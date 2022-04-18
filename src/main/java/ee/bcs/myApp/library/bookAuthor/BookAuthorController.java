package ee.bcs.myApp.library.bookAuthor;

import ee.bcs.myApp.library.author.AuthorDto;
import ee.bcs.myApp.library.book.BookDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book-author")
public class BookAuthorController {

    @Resource
    private ee.bcs.myApp.library.bookAuthor.BookAuthorService bookAuthorService;

    @PostMapping("/book-and-author")
    @Operation(summary = "Lisab samaaegselt uue raamatu ja uue autori")
    public void addBookAndAuthor(@RequestBody BookAuthorDto bookAuthorDto) {
        bookAuthorService.addBookAndAuthor(bookAuthorDto);
    }

    @PutMapping("/connect")
    @Operation(summary = "Loob seose autori ja raamatu vahel")
    public void connectBookWithAuthor(@RequestParam String lastName, @RequestParam String bookName) {
        bookAuthorService.connectBookWithAuthor(lastName, bookName);
    }


//        public void demo1() {
//        Author author = authorRepository.getByLastName("Banderas");
//        Book book = bookRepository.findByTitle("Harry Potter");
//        BookAuthor bookAuthor = new BookAuthor();
//        bookAuthor.setAuthor(author);
//        bookAuthor.setBook(book);
//        bookAuthorRepository.save(bookAuthor);
//

//    }

}

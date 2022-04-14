package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.AuthorRepository;
import ee.bcs.myApp.library.book.BookRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/book-author")
public class BookAuthorController {

    @Resource         // peaks tegema service kalssi
    private AuthorRepository authorRepository;

    @Resource         // peaks tegema service kalssi
    private BookRepository bookRepository;

    @Resource         // peaks tegema service kalssi
    private BookAuthorRepository bookAuthorRepository;


    @GetMapping
    public void demo() {

    }
}

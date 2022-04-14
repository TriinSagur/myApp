package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.author.AuthorRepository;
import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/book-author")
public class BookAuthorController {

    @Resource
    private BookRepository bookRepository;

    @Resource
    private AuthorRepository authorRepository;

    @Resource
    private BookAuthorRepository bookAuthorRepository;

    @GetMapping
    public void demo1() {
        Author author = authorRepository.getByLastName("Banderas");
        Book book = bookRepository.findByTitle("Harry Potter");
        BookAuthor bookAuthor = new BookAuthor();
        bookAuthor.setAuthor(author);
        bookAuthor.setBook(book);
        bookAuthorRepository.save(bookAuthor);


    }
}

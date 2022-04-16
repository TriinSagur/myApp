package ee.bcs.myApp.library.bookAuthor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/book-author")
public class BookAuthorController {

    @Resource
    private BookAuthorService bookAuthorService;

    //    public void demo1() {
//        Author author = authorRepository.getByLastName("Banderas");
//        Book book = bookRepository.findByTitle("Harry Potter");
//        BookAuthor bookAuthor = new BookAuthor();
//        bookAuthor.setAuthor(author);
//        bookAuthor.setBook(book);
//        bookAuthorRepository.save(bookAuthor);
//
//
//    }

}

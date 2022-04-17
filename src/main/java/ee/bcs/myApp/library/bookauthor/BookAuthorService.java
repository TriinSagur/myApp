package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.author.AuthorRepository;
import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookRepository;
import ee.bcs.myApp.library.keyword.KeywordDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookAuthorService {

    @Resource
    private BookAuthorMapper bookAuthorMapper;

    @Resource
    private BookRepository bookRepository;

    @Resource
    private AuthorRepository authorRepository;

    @Resource
    private BookAuthorRepository bookAuthorRepository;




//    public void demo1() {
//        Author author = authorRepository.getByLastName("Banderas");
//        Book book = bookRepository.findByTitle("Harry Potter");
//        BookAuthor bookAuthor = new BookAuthor();
//        bookAuthor.setAuthor(author);
//        bookAuthor.setBook(book);
//        bookAuthorRepository.save(bookAuthor);
//    }

    public List<BookAuthorDto> findAllBookAuthors() {
        List<BookAuthor> bookAuthors = bookAuthorRepository.findAll();
        return bookAuthorMapper.toDtos(bookAuthors);
    }

    public BookAuthorDto findById(Integer id) {
        BookAuthor bookAuthor = bookAuthorRepository.getById(id);
        return bookAuthorMapper.toDto(bookAuthor);
    }


    public void addNew(String title, String lastName) {
        BookAuthor bookAuthor = new BookAuthor();
        Book book = bookRepository.findByTitle(title);
        Author author = authorRepository.getByLastName(lastName);
        bookAuthor.setAuthor(author);
        bookAuthor.setBook(book);
        bookAuthorRepository.save(bookAuthor);
    }
}


package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.author.AuthorDto;
import ee.bcs.myApp.library.author.AuthorRepository;
import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookDto;
import ee.bcs.myApp.library.book.BookMapper;
import ee.bcs.myApp.library.book.BookRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookAuthorService {

    @Resource
    private AuthorRepository authorRepository;

    @Resource
    private BookRepository bookRepository;

    @Resource
    private BookMapper bookMapper;

    @Resource
    private BookAuthorRepository bookAuthorRepository;

    @Resource
    private BookAuthorMapper bookAuthorMapper;


    public List<BookAuthorResponse> getAllBookAuthors() {
        List<BookAuthor> bookAuthors = bookAuthorRepository.findAll();
        return bookAuthorMapper.toBookAuthorResponses(bookAuthors);
    }

    public List<BookDto> getAllBooksForAuthor(String lastName) {
        List<BookAuthor> bookAuthors = bookAuthorRepository.findByAuthorIs(lastName);
        List<Book> books = new ArrayList<>();
        for (BookAuthor bookAuthor : bookAuthors) {
            books.add(bookAuthor.getBook());
        }
        return bookMapper.toDtos(books);
    }

    public void addBookAndAuthor(AddBookAuthorDto bookAuthorDto) {
        BookAuthor bookAuthor = bookAuthorMapper.toAddBookAuthorEntity(bookAuthorDto);
        authorRepository.save(bookAuthor.getAuthor());
        bookRepository.save(bookAuthor.getBook());
        bookAuthorRepository.save(bookAuthor);
    }
}

package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.author.AuthorRepository;
import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookDto;
import ee.bcs.myApp.library.book.BookMapper;
import ee.bcs.myApp.library.book.BookRepository;
import ee.bcs.myApp.library.service.BookAuthorRequest;
import ee.bcs.myApp.library.service.BookAuthorResponse;
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

    public List<BookAuthorResponse> getAllBooksWithAuthors() {
        List<BookAuthor> bookAuthors = bookAuthorRepository.findAll();
        return bookAuthorMapper.toBookAuthorResponses(bookAuthors);
    }

    public List<BookDto> getAllBooksForAuthor(String lastName) {
        List<BookAuthor> bookAuthors = bookAuthorRepository.findByAuthor(lastName);
        List<Book> books = new ArrayList<>();
        for (BookAuthor bookAuthor : bookAuthors) {
            books.add(bookAuthor.getBook());
        }
        return bookMapper.toDtos(books);
    }

    public void addBookAndAuthor(BookAuthorRequest bookAuthorDto) {
        BookAuthor bookAuthor = bookAuthorMapper.toAddBookAuthorEntity(bookAuthorDto);
        authorRepository.save(bookAuthor.getAuthor());
        bookRepository.save(bookAuthor.getBook());
        bookAuthorRepository.save(bookAuthor);
    }

    public void addAuthorToBook(Integer bookId, Integer authorId) {
        Book book = bookRepository.getById(bookId);
        Author author = authorRepository.getById(authorId);
        BookAuthor bookAuthor = new BookAuthor(book,author);
        bookAuthorRepository.save(bookAuthor);
    }

    public void removeAuthorFromBook(Integer bookAuthorId) {
        bookAuthorRepository.deleteById(bookAuthorId);
    }

    public List<BookAuthorResponse> getBooksAndAuthorsByWord(String word) {
        List<BookAuthor> bookAuthors = bookAuthorRepository.findByWord(word, word, word);
        return bookAuthorMapper.toBookAuthorResponses(bookAuthors);
    }
}

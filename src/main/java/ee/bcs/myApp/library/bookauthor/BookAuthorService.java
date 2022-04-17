package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.author.AuthorRepository;
import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookAuthorService {

    @Resource
    private BookAuthorMapper bookAuthorMapper;

    @Resource
    private BookAuthorRepository bookAuthorRepository;

    @Resource
    private AuthorRepository authorRepository;

    @Resource
    private BookRepository bookRepository;

        public void demo1() {
            Author author = authorRepository.getByLastName("Banderas");
            Book book = bookRepository.findByTitle("Harry Potter");
            BookAuthor bookAuthor = new BookAuthor();
            bookAuthor.setAuthor(author);
            bookAuthor.setBook(book);
            bookAuthorRepository.save(bookAuthor);
        }


    public BookAuthorDto addNewBookAuthorConnection(Integer bookId, Integer authorId) {
        Author author = authorRepository.getById(authorId);
        Book book = bookRepository.getById(bookId);
        BookAuthor bookAuthor = new BookAuthor();
        bookAuthor.setAuthor(author);
        bookAuthor.setBook(book);
        bookAuthorRepository.save(bookAuthor);
        return bookAuthorMapper.toDto(bookAuthor);
    }

    public BookAuthorDto addNewBookAuthor1(BookAuthorDto bookAuthorDto) {
        BookAuthor bookAuthor = bookAuthorMapper.toEntity(bookAuthorDto);
        bookRepository.save(bookAuthor.getBook());
        authorRepository.save(bookAuthor.getAuthor());
        bookAuthorRepository.save(bookAuthor);
        return bookAuthorMapper.toDto(bookAuthor);
    }

    public List<BookAuthorDto> getAllBookAuthors() {
        List<BookAuthor> bookAuthors = bookAuthorRepository.findAll();
        return bookAuthorMapper.toDtos(bookAuthors);
    }

    public void removeBookAuthorById(Integer id) {
        bookAuthorRepository.deleteById(id);
    }

    public BookAuthorDto updateBookAuthorById(Integer id, BookAuthorDto bookAuthorDto) {
        BookAuthor bookAuthor = bookAuthorRepository.getById(id);
        bookAuthorDto.setId(id);
        bookAuthorMapper.updateEntity(bookAuthorDto, bookAuthor);
        bookAuthorRepository.save(bookAuthor);
        return bookAuthorMapper.toDto(bookAuthor);
    }

    public List<BookAuthorDto> getAllAuthorBooks(Integer authorId) {
        List<BookAuthor> books = new ArrayList<>();
        books = bookAuthorRepository.getByAuthorId(authorId);
        return bookAuthorMapper.toDtos(books);
    }
}

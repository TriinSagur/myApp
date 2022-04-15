package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.author.AuthorDto;
import ee.bcs.myApp.library.author.AuthorRepository;
import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookRepository;
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


    public void addNewBookAuthor(String title, String lastName) {
        BookAuthor bookAuthor = new BookAuthor();
        Book book = bookRepository.findByTitle(title);
        Author author = authorRepository.getByLastName(lastName);
        bookAuthor.setBook(book);
        bookAuthor.setAuthor(author);
        bookAuthorRepository.save(bookAuthor);
    }

    public List<BookAuthorDto> getAllBookAuthors() {
        List<BookAuthor> bookAuthors = bookAuthorRepository.findAll();
        return bookAuthorMapper.toDtos(bookAuthors);
    }

    public BookAuthorDto findBookAuthorById(Integer id) {
        BookAuthor bookAuthor = bookAuthorRepository.getById(id);
        return bookAuthorMapper.toDto(bookAuthor);
    }

    public void removeBookAuthorById(Integer id) {
        bookAuthorRepository.deleteById(id);
    }

    public void updateBookAuthor(Integer id, String title, String lastName) {
        BookAuthor bookAuthor = bookAuthorRepository.getById(id);
        Book book = bookRepository.findByTitle(title);
        Author author = authorRepository.getByLastName(lastName);
        bookAuthor.setBook(book);
        bookAuthor.setAuthor(author);
        bookAuthorRepository.save(bookAuthor);
    }


    public List<BookAuthorDto> getAllBooksByAuthor(String lastName) {
        List<BookAuthor> bookAuthors = bookAuthorRepository.findByAuthorLastName(lastName);
        return bookAuthorMapper.toDtos(bookAuthors);
    }
}

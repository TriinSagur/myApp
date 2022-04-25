package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.*;
import ee.bcs.myApp.library.book.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookAuthorService {

    @Resource
    private BookAuthorRepository bookAuthorRepository;

    @Resource
    private BookAuthorMapper bookAuthorMapper;

    @Resource
    private AuthorService authorService;

    @Resource
    private BookService bookService;


    public List<BookAuthorDto> getAllBookAuthors() {
        List<BookAuthor> bookAuthors = bookAuthorRepository.findAll();
        return bookAuthorMapper.toDtos(bookAuthors);
    }

    public BookAuthorDto getBookAuthorById(Integer id) {
        BookAuthor bookAuthor = bookAuthorRepository.getById(id);
        return bookAuthorMapper.toDto(bookAuthor);
    }

    public BookAuthorDto addNewBookAndAuthor(BookAuthorDto bookAuthorDto) {
        Author author = authorService.getAndSaveAuthor(bookAuthorDto);
        Book book = bookService.getAndSaveBook(bookAuthorDto);
        BookAuthor bookAuthor = getAndSaveBookAuthor(bookAuthorDto, author, book);
        return bookAuthorMapper.toDto(bookAuthor);
    }

    public void addBookAndAuthorConnection(Integer authorId, Integer bookId) {
        BookAuthor bookAuthor = new BookAuthor();
        Book book = bookService.getBookEntityById(bookId);
        Author author = authorService.getAuthorEntityById(authorId);
        bookAuthor.setAuthor(author);
        bookAuthor.setBook(book);
        bookAuthorRepository.save(bookAuthor);
    }

    public void deleteBookAuthor(Integer id) {
        bookAuthorRepository.deleteById(id);
    }




    private BookAuthor getAndSaveBookAuthor(BookAuthorDto bookAuthorDto, Author author, Book book) {
        BookAuthor bookAuthor = bookAuthorMapper.toEntity(bookAuthorDto);
        bookAuthor.setBook(book);
        bookAuthor.setAuthor(author);
        bookAuthorRepository.save(bookAuthor);
        return bookAuthor;
    }

}

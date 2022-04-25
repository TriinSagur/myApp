package ee.bcs.myApp.library.book;

import ee.bcs.myApp.library.bookauthor.BookAuthorDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookService {

    @Resource
    private BookMapper bookMapper;

    @Resource
    private BookRepository bookRepository;

    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.toDtos(books);
    }

    public BookDto getBookByTitel(String titel) {
        Book book = bookRepository.findByTitle(titel);
        bookMapper.toDto(book);
        return bookMapper.toDto(book);
    }

    public BookDto addNewBook(BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        Book save = bookRepository.save(book);
        return bookMapper.toDto(save);
    }

    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }

    public void updateBookByTitle(String titel, BookDto bookDto) {
        Book book = bookRepository.findByTitle(titel);
        bookMapper.updateEntity(bookDto, book);
        bookRepository.save(book);
    }

    public Book getAndSaveBook(BookAuthorDto bookAuthorDto) {
        BookDto bookDto = new BookDto();
        bookDto.setYear(bookAuthorDto.getBookYear());
        bookDto.setTitle(bookAuthorDto.getBookTitle());
        Book book = bookMapper.toEntity(bookDto);
        bookRepository.save(book);
        return book;
    }

    public Book getBookEntityById(Integer bookId) {
        return bookRepository.getById(bookId);
    }
}

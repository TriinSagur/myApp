package ee.bcs.myApp.library.book;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Resource
    private BookMapper bookMapper;

    @Resource
    private BookRepository bookRepository;

    public BookDto addNewBook(BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        bookRepository.save(book);
        return bookMapper.toDto(book);
    }

    public List<BookDto> getAllBooks() {
        List<Book> allBooks = bookRepository.findAll();
        return bookMapper.toDtos(allBooks);
    }

    public BookDto findBookById(Integer id) {
        Book book = bookRepository.getById(id);
        return bookMapper.toDto(book);
    }

    public void removeBookById(Integer id) {
        bookRepository.deleteById(id);
    }

    public void updateBookById(Integer bookId, BookDto bookDto) {
        Book book = bookRepository.getById(bookId);
        bookMapper.updateEntity(bookDto, book);
        bookRepository.save(book);
    }
}

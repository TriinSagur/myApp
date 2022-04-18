package ee.bcs.myApp.library.book;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookService {

    @Resource
    private BookMapper bookMapper;

    @Resource
    private BookRepository bookRepository;


    public BookDto addNewBook(BookDto bookDto) {
        Book book = bookMapper.bookDtoToBook(bookDto);
        bookRepository.save(book);
        return bookMapper.bookToBookDto(book);
    }

    public List<BookDto> getAllBooks() {
        List<Book> allBooks = bookRepository.findAll();
        return bookMapper.bookToBookDtos(allBooks);
    }

    public BookDto findBookById(Integer id) {
        Book book = bookRepository.getById(id);
        return bookMapper.bookToBookDto(book);
    }

    public void removeBookById(Integer id) {
        bookRepository.deleteById(id);
    }

    public void updateBookById(Integer id, BookDto bookDto) {
        Book book = bookRepository.getById(id);
        bookMapper.updateBookFromBookDto(bookDto, book);
        bookRepository.save(book);
    }
}

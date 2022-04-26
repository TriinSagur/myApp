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

        Book book = bookMapper.toBookEntity(bookDto);
        bookRepository.save(book);
        return bookMapper.toBookDto(book);

    }

    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.toDtos(books);
    }

    public BookDto findBookById(Integer id) {
        Book book = bookRepository.getById(id);
        return bookMapper.toBookDto(book);
    }


    public BookDto findBookByYear(Integer year) {
        Book byYear = bookRepository.findByYear(year);              // ei tööta
        return bookMapper.toBookDto(byYear);
    }

    public List<BookDto> findBooksByYear(Integer year) {
        List<Book> books = BookRepository.findsByYear(year);
        return bookMapper.toDtos(books);

    }

    public void removeBookById(Integer id) {
//        Book book = bookRepository.getById(id);
//        bookRepository.delete(book);
        bookRepository.deleteById(id);
    }
}

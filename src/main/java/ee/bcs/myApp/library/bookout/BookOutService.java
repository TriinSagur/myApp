package ee.bcs.myApp.library.bookout;

import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookDto;
import ee.bcs.myApp.library.book.BookRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookOutService {

    @Resource
    private BookOutRepository bookOutRepository;
    @Resource
    private BookOutMapper bookOutMapper;
    @Resource
    private BookRepository bookRepository;


    public BookOutDto addBookById(Integer id) {
        Book book = bookRepository.getById(id);
        BookOut bookOut = new BookOut();
        bookOut.setBook(book);
        bookOut.setIsReturned(true);
        bookOutRepository.save(bookOut);
        return bookOutMapper.toDto(bookOut);
    }


    public BookOutDto loanBook(Integer id) {
        BookOut bookOut = bookOutRepository.getById(id);
        bookOut.setIsReturned(false);
        bookOutRepository.save(bookOut);
        return bookOutMapper.toDto(bookOut);
    }


    public BookOutDto returnBook(Integer id) {
        BookOut bookOut = bookOutRepository.getById(id);
        bookOut.setIsReturned(true);
        bookOutRepository.save(bookOut);
        return bookOutMapper.toDto(bookOut);
    }

    public List<BookOutDto> getAllBookStatus() {
        List<BookOut> bookOuts = bookOutRepository.findAll();
        return bookOutMapper.toDtos(bookOuts);
    }

    public BookOutDto getBookStatusById(Integer id) {
        BookOut bookOut = bookOutRepository.getById(id);
        return bookOutMapper.toDto(bookOut);
    }

    public void removeBookById(Integer id) {
        bookOutRepository.deleteById(id);
    }

}

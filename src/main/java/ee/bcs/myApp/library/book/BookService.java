package ee.bcs.myApp.library.book;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.author.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Resource
    private BookMapper bookMapper;
    @Resource
    private BookRepository bookRepository;
    @Resource
    private AuthorRepository authorRepository;

    public BookDto addNewBook(BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        bookRepository.save(book);
        return bookMapper.toDto(book);
    }


    public List<BookDto> returnAllBooks() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.toDtos(books);
    }

    public BookDto findBookById(Integer id) {
        Book book = bookRepository.getById(id);
        return bookMapper.toDto(book);
    }

    public void removeBookById(Integer id) {
        bookRepository.deleteById(id);
    }


    public void updateBookById(Integer id, BookDto bookDto) {
        Book book = bookRepository.getById(id);
        bookMapper.updateEntity(bookDto, book);
        bookRepository.save(book);
    }


}

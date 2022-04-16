package ee.bcs.myApp.library.book;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookService {

    @Resource
    private BookRepository bookRepository;

    @Resource
    private BookMapper bookMapper;

    public BookDto addNewBook(BookDto bookDto) {

        Book book = bookMapper.bookToEntity(bookDto);
        bookRepository.save(book);

        return bookMapper.bookToDto(book);
    }

    public List<BookDto> findAllBooks() {
        List<Book> allBooks = bookRepository.findAll();
        return bookMapper.toDtos(allBooks);
    }



//    public Book findBookById(Integer id) {
//
//    }
//
//    public void removeBookById(Integer id) {
//
//    }
//
//    public List<BookDto> findAllBooks() {
//
//        return findAllBooks();
//    }
}


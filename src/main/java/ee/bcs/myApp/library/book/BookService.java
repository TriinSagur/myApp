package ee.bcs.myApp.library.book;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookService {

    @Resource
    private BookRepository bookRepository;

    public BookDto addNewBook(BookDto bookDto) {



        return book.getId();
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


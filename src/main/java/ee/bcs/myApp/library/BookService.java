package ee.bcs.myApp.library;

import ee.bcs.myApp.MyAppApplication;
import ee.bcs.myApp.bank.CustomerDto;
import org.apache.catalina.webresources.ClasspathURLStreamHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    public Integer addNewBook(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.updateId();

        List<Book> books = MyAppApplication.libraryRepository.getBooks();
        books.add(book);
        return book.getId();
    }


    public Book findBookById(Integer id) {
        List<Book> books = MyAppApplication.libraryRepository.getBooks();
        Book result = new Book();
        for (Book book1 : books) {
            if (book1.getId().equals(id)) {
                result = book1;
            }
        }

        return result;
    }

    public List<Book> getAllBooks() {
        return MyAppApplication.libraryRepository.getBooks();
    }

    public void removeBookById(Integer id) {
        List<Book> books = MyAppApplication.libraryRepository.getBooks();
        Book result = new Book();
        for (Book book : books) {
            if (book.getId().equals(id)) {
                result = book;
            }
        }
        books.remove(result);
    }

    public void updateBookById(Integer id, BookDto bookDto) {
        Book book = findBookById(id);
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
    }
}

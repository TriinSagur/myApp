package ee.bcs.myApp.library;

import ee.bcs.myApp.MyAppApplication;
import io.swagger.v3.oas.models.security.SecurityScheme;
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


        for (Book book : books) {
            if (book.getId().equals(id)) {
                result = book;
            }
        }

        return result;

    }

    public List<Book> findAllBooks() {


        return MyAppApplication.libraryRepository.getBooks();
    }

    public void updateBookById(Integer id, BookDto bookDto) {
        Book book = findBookById(id);
        book.setYear(bookDto.getYear());
        book.setTitle(bookDto.getTitle());

    }

    public void removeBookById(Integer id) {
        List<Book> books = MyAppApplication.libraryRepository.getBooks();

        Book book = findBookById(id);

        books.remove(book);

    }
}

package ee.bcs.myApp.library;

import ee.bcs.myApp.MyAppApplication;
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


    public static List<Book> getAllBooks() {
        return MyAppApplication.libraryRepository.getBooks();
    }


    public static Book getBookById(Integer id) {
        List<Book> books = MyAppApplication.libraryRepository.getBooks();
        Book result = new Book();
        for (Book book : books) {
            if(book.getId().equals(id)) {
                result = book;
            }

        }
        return result;
    }


    public void deleteBookById(Integer id) {
        List<Book> books = MyAppApplication.libraryRepository.getBooks();
        Book result = new Book();
        for (Book book : books) {
            if (book.getId().equals(id)) {
                result = book;
            }
        }
        books.remove(result);
    }

    public void updateBooksById(Integer id, BookDto bookDto) {
        Book book = getBookById(id);
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());

    }
}

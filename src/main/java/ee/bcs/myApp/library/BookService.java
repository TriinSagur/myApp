package ee.bcs.myApp.library;

import ee.bcs.myApp.MyAppApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    public List<Book> getAllBooks() {
        return MyAppApplication.libraryRepository.getBooks();
    }

    public Book findBookById(@RequestParam Integer id) {
        List<Book> books = MyAppApplication.libraryRepository.getBooks();
        Book result = new Book();
        for (Book book : books) {
            if (book.getId().equals(id)) {
                result = book;
            }
        }
        return result;
    }

    public void updateBookById(Integer id, BookDto bookDto) {
        Book book = findBookById(id);
        book.setYear(bookDto.getYear());
        book.setTitle(bookDto.getTitle());
    }

    public void removeBookById(Integer id) {
        List<Book> books = MyAppApplication.libraryRepository.getBooks();
        Book result = new Book();
        for (Book book : books) {
            if (book.getId().equals(id)) { // see id tuleb parameetrist(mida me küsime tagasi)
                result = book;
            }
        }
        books.remove(result);
    }
}

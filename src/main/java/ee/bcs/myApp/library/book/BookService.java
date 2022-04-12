package ee.bcs.myApp.library.book;

import ee.bcs.myApp.MyAppApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class BookService {

    public BookDto addNewBook(BookDto bookDto) {
        List<Book> books = MyAppApplication.libraryRepository.getBooks();

        Book book = toEntity(bookDto);
        book.updateId();
        books.add(book);

        bookDto = toDto(book);

        return bookDto;
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

    private Book toEntity(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        return book;
    }

    private BookDto toDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setTitle(book.getTitle());
        bookDto.setYear(book.getYear());
        return bookDto;
    }
}

package ee.bcs.myApp.library.book;

import ee.bcs.myApp.MyAppApplication;
import ee.bcs.myApp.bank.customer.Customer;
import ee.bcs.myApp.library.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {


    public List<BookDto> findAllBooks() {
        Library libraryRepository = MyAppApplication.libraryRepository;
        List<Book> books = libraryRepository.getBooks();

        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : books) {
            BookDto bookDto = toDto(book);
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }


    public BookDto addNewBook(BookDto bookDto) {
        Book book = toEntity(bookDto);
        List<Book> books = MyAppApplication.libraryRepository.getBooks();
        books.add(book);
//        book.updateId();
        return toDto(book);

    }

    private Book toEntity(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        return book;
    }

    private BookDto toDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setYear(book.getYear());
        return bookDto;
    }

    public Book findBookEntityById(Integer id) {
        List<Book> books = MyAppApplication.libraryRepository.getBooks();
        Book result = new Book();
        for (Book book : books) {
            if (book.getId().equals(id)) {
                result = book;
            }
        }
        return result;
    }


    public List<BookDto> returnAllBooks() {
        return null;
    }

    public void removeBookById(Integer id) {
    }

    public void removeBookByName(String title) {
    }
}
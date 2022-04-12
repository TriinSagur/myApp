package ee.bcs.myApp.library;

import ee.bcs.myApp.MyAppApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
        book.updateId();
        List<Book> books = MyAppApplication.libraryRepository.getBooks();
        books.add(book);
        return bookDto;
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

    List<Book> books = MyAppApplication.libraryRepository.getBooks();

    public void removeBookById(@RequestParam Integer id) {
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

    }


    private Book toEntity(BookDto bookDto) {
        Book book = new Book();
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


}
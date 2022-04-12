package ee.bcs.myApp.library.book;

import ee.bcs.myApp.MyAppApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    public Integer addNewBook(BookDto bookDto) {
        Book book = toEntity(bookDto);

        book.updateId();

        List<Book> books = MyAppApplication.libraryRepository.getBooks();
        books.add(book);

        return book.getId();
    }

    public List<BookDto> getAllBooks() {
        List<Book> books = MyAppApplication.libraryRepository.getBooks();

        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : books) {
            BookDto bookDto = toDto(book);
            bookDtos.add(bookDto);

        }

        return bookDtos;
    }


    public BookDto findBookById(Integer id) {
        Book result = findBookEntityById(id);
        BookDto bookDto = toDto(result);
        return bookDto;

    }

    private Book findBookEntityById(Integer id) {
        List <Book> books = MyAppApplication.libraryRepository.getBooks();
        Book result = new Book();
        for (Book book : books) {
            if (book.getId().equals(id)) {
                result = book;
            }

        }
        return result;
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
        Book book = findBookEntityById(id);
        book.setYear(bookDto.getYear());
        book.setTitle(bookDto.getTitle());
    }

    private BookDto toDto(Book book) {
        BookDto bookDto;
        bookDto = new BookDto();
        bookDto.setTitle(book.getTitle());
        bookDto.setYear(book.getYear());
        return bookDto;
    }

    private Book toEntity(BookDto bookDto) {
        Book book = new Book();
        book.setYear(bookDto.getYear());
        book.setTitle(bookDto.getTitle());
        return book;
    }
}

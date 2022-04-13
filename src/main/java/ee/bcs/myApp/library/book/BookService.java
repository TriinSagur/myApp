package ee.bcs.myApp.library.book;

import ee.bcs.myApp.MyAppApplication;
import ee.bcs.myApp.library.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    public BookDto addNewBook(BookDto bookDto) {
        Book book = toEntity(bookDto);
        book.updateId();

        List<Book> books = MyAppApplication.libraryRepository.getBooks();
        books.add(book);
        return toDto(book);
    }


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

    private BookDto toDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setYear(book.getYear());
        return bookDto;
    }

    private Book toEntity(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        return book;
    }



}

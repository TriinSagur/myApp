package ee.bcs.myApp.library;

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

    private Book toEntity(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        return book;
    }


    public Book findBookById(Integer id) {
        List<Book> books = MyAppApplication.libraryRepository.getBooks();
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void removeBookById(Integer id) {
        Book bookToRemove = findBookById(id);
        List<Book> books = MyAppApplication.libraryRepository.getBooks();
        books.remove(bookToRemove);

    }

    public void updateBookById(Integer id, BookDto bookDto) {
        Book bookToUpdate = findBookById(id);
        bookToUpdate.setYear(bookDto.getYear());
        bookToUpdate.setTitle(bookDto.getTitle());
    }

    public List<BookDto> getAllBooks() {
        Library libraryRepository = MyAppApplication.libraryRepository;
        List<Book> books = libraryRepository.getBooks();

        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : books) {
            BookDto bookDto = new BookDto();
            bookDto.setTitle(book.getTitle());
            bookDto.setYear(book.getYear());
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }
}

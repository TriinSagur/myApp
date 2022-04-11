package ee.bcs.myApp.library;

import ee.bcs.myApp.MyAppApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    public BookDto findBookById(Integer id) {
        BookDto bookDto = new BookDto();
        Book bookFound = new Book ();
        List<Book> books = MyAppApplication.libraryRepository.getBooks();
        for (Book book : books) {
            if(book.getId().equals(id)){
                bookFound = book;
            }
        }
        bookDto.setYear(bookFound.getYear());
        bookDto.setTitle(bookFound.getTitle());
        return bookDto;
    }

    public void deleteBookById(Integer id) {
        List<Book> books = MyAppApplication.libraryRepository.getBooks();
        Book foundBook = new Book();
        for (Book book : books) {
            if(book.getId().equals(id)){
                foundBook = book;
            }
        }
        books.remove(foundBook);
    }

    public void changeBookById(Integer id, BookDto bookDto) {
        List<Book> books = MyAppApplication.libraryRepository.getBooks();
        Book foundBook = new Book();
        for (Book book : books) {
            if(book.getId().equals(id)){
                foundBook = book;
            }
        }
        foundBook.setYear(bookDto.getYear());
        foundBook.setTitle(bookDto.getTitle());
    }
}

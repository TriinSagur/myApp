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
}

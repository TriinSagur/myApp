package ee.bcs.myApp.library;


import ee.bcs.myApp.MyAppApplication;
import ee.bcs.myApp.bank.Customer;
import ee.bcs.myApp.bank.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    public Integer addNewBook(BookDto bookDto){
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.updateId();
        List<Book> books = MyAppApplication.libraryRepository.getBooks();
        books.add(book);
        return book.getId();
    }

}

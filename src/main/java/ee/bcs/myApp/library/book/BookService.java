package ee.bcs.myApp.library.book;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    public Integer addNewBook(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(book.getTitle());
        book.setYear(book.getYear());
        book.updateId();

//        List<Book> books = MyAppApplication.libraryRepository.getBooks();
//        books.add(book);

        return book.getId();
    }

//    public List<>

}

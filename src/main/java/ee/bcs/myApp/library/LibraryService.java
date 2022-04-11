//package ee.bcs.myApp.library;
//
//import ee.bcs.myApp.MyAppApplication;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class LibraryService {
//    public Integer addNewBook(BookDto bookDto){
//        Book book = new Book();
//        book.setTitle(bookDto.getTitle());
//        book.setYear(bookDto.getYear());
//        book.updateId();
//        List<Book> books = MyAppApplication.libraryRepository.getBooks();
//        books.add(book);
//        return book.getId();
//    }
//
//    public List<Book> getAllBooks() {
//            return MyAppApplication.libraryRepository.getBooks();
//    }
//}

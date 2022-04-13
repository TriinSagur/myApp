//package ee.bcs.myApp.library.book;
//
//import ee.bcs.myApp.MyAppApplication;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//
//@Service
//public class BookService {
//
//    public static Integer addNewBook(BookDto bookDto) {
//        Book book = new Book();
//        book.setTitle(bookDto.getTitle());
//        book.setYear(bookDto.getYear());
//        book.updateId();
//
//        List <Book> books = MyAppApplication.libraryRepository.getBooks();
//        books.add(book);
//
//        return book.getId();
//
//    }
//
//    public void removeBookById(@RequestParam BookDto bookDto) {
//        List<Book> books = MyAppApplication.libraryRepository.getBooks();
//        Book result = new Book();
//        for (Book book : books) {
//            if (book.getId().equals(book.id)) {
//                result = book;
//            }
//        }
//    }
//
////    public void updateBookById(Integer id, BookDto bookDto) {
////        Book book = findBookById(id);
////        book.setTitle(bookDto.setTitle; }
//
//
//
//
//
//
//
//}
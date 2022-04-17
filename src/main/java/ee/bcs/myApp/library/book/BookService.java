//package ee.bcs.myApp.library;
//
//import ee.bcs.myApp.MyAppApplication;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BookService {
//    public Integer addNewBook(BookDto1 bookDto) {
//        Book book = new Book();
//        book.setTitle(bookDto.getTitle());
//        book.setYear(bookDto.getYear());
//        book.updatedId();
//        List<Book> books = MyAppApplication.libraryRepository.getBooks();
//        books.add(book);
//        return book.getId();
//    }
//
//    public List<Book> getAllBooks() {
//        return MyAppApplication.libraryRepository.getBooks();
//    }
//
//    public Book findBookById(Integer id) {
//        List<Book> books = MyAppApplication.libraryRepository.getBooks();
//        Book result = new Book();
//        for (Book book : books) {
//            if (book.getId().equals(id)) {
//                result = book;
//            }
//        }
//        return result;
//    }
//
//    public void removeBookById(Integer id) {
//        List<Book> books = MyAppApplication.libraryRepository.getBooks();
//        Book result = new Book();
//        for (Book book : books) {
//            if (book.getId().equals(id)) {
//                result = book;
//            }
//        }
//        books.remove(result);
//    }
//
//    public void updateBookById(Integer id, BookDto1 bookDto) {
//        Book book = findBookById(id);
//        book.setTitle(bookDto.getTitle());
//        book.setYear(bookDto.getYear());
//
//    }
//}

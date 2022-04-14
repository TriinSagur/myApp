//package ee.bcs.myApp.library.book;
//
//
//import ee.bcs.myApp.MyAppApplication;
//import ee.bcs.myApp.library.Library;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BookService {
//
//    public Integer addNewBook(BookDto bookDto) {
//        Book book = new Book();
//        book.setTitle(bookDto.getTitle());
//        book.setYear(bookDto.getYear());
//        book.updateId();
//        List<Book> books = MyAppApplication.libraryRepository.getBooks();
//        books.add(book);
//
//        return book.getId();
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
//    public List<BookDto> findAllBooks() {
//        Library libraryRepository = MyAppApplication.libraryRepository;
//        List<Book> books = libraryRepository.getBooks();
//
//        for (Book book:books) {
//            BookDto bookDto = new BookDto();
//            bookDto.setTitle(book.getTitle());
//            bookDto.setYear(book.getYear());
//
//            System.out.println(book);
//
//        }
//        return findAllBooks();
//    }
//}
//

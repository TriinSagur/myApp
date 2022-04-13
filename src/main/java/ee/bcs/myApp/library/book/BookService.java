//package ee.bcs.myApp.library.book;
//
//import ee.bcs.myApp.MyAppApplication;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class BookService {
//
//    public BookDto addNewBook(BookDto bookDto) {
//        List<Book> books = MyAppApplication.libraryRepository.getBooks();
//        Book book = toEntity(bookDto);
//        book.updateId();
//        books.add(book);
//        bookDto = toDto(book);
//        return bookDto;
//    }
//
//    public List<BookDto> getAllBooks() {
//        List<Book>books = MyAppApplication.libraryRepository.getBooks();
//        List<BookDto> bookDtos = new ArrayList<>();
//
//        for (Book book : books) {
//            BookDto bookDto = toDto(book);
//            bookDtos.add(bookDto);
//        }
//        return bookDtos;
//    }
//
//    public BookDto findBookById(Integer id) {
//        Book result = findBookEntityById(id);
//        return toDto(result);
//    }
//
//    private Book findBookEntityById(Integer id) {
//        List<Book> books = MyAppApplication.libraryRepository.getBooks();
//        Book result = new Book();
//
//        for (Book book : books) {
//            if (book.getId().equals(id)) {
//                result = book;
//            }
//        }
//        return result;
//    }
//
//    public void updateBookById(Integer id, BookDto bookDto) {
//        Book book = findBookEntityById(id);
//        book.setYear(bookDto.getYear());
//        book.setTitle(bookDto.getTitle());
//    }
//
//    public void removeBookById(Integer id) {
//        List<Book> books = MyAppApplication.libraryRepository.getBooks();
//        Book result = new Book();
//        for (Book book : books) {
//            if (book.getId().equals(id)) { // see id tuleb parameetrist(mida me küsime tagasi)
//                result = book;
//            }
//        }
//        books.remove(result);
//    }
//
//    private Book toEntity(BookDto bookDto) {
//        Book book = new Book();
//        book.setTitle(bookDto.getTitle());
//        book.setYear(bookDto.getYear());
//        return book;
//    }
//
//    private BookDto toDto(Book book) {
//        BookDto bookDto = new BookDto();
//        bookDto.setTitle(book.getTitle());
//        bookDto.setYear(book.getYear());
//        return bookDto;
//    }
//}

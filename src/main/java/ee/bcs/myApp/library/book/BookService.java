//package ee.bcs.myApp.library.book;
//
//import ee.bcs.myApp.MyAppApplication;
//import ee.bcs.myApp.library.Library;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class BookService {
//
//    public BookDto addNewBook(BookDto bookDto) {
//        Book book = toEntity(bookDto);
//        book.updateId();
//
//        List<Book> books = MyAppApplication.libraryRepository.getBooks();
//        books.add(book);
//        return toDto(book);
//    }
//
//    public BookDto findBookById(Integer id) {
//        List<Book> books = MyAppApplication.libraryRepository.getBooks();
//        Book result = new Book();
//        for (Book book1 : books) {
//            if (book1.getId().equals(id)) {
//                result = book1;
//            }
//        }
//        return toDto(result);
//    }
//
//    public List<BookDto> getAllBooks() {
//        Library libraryRepository = MyAppApplication.libraryRepository;
//        List<Book> books = libraryRepository.getBooks();
//
//        List<BookDto> bookDtos = new ArrayList<>();
//        for (Book book : books) {
//            BookDto bookDto = toDto(book);
//            bookDtos.add(bookDto);
//        }
//        return bookDtos;
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
//    public void updateBookById(Integer id, BookDto bookDto) {
//        Book book = findBookEntityById(id);
//        book.setTitle(bookDto.getTitle());
//        book.setYear(bookDto.getYear());
//        book.setAuthors(bookDto.getAuthors());
//    }
//
//    private Book toEntity(BookDto bookDto) {
//        Book book = new Book();
//        book.setTitle(bookDto.getTitle());
//        book.setYear(bookDto.getYear());
//        book.setAuthors(bookDto.getAuthors());
//        return book;
//    }
//
//    private BookDto toDto(Book book) {
//        BookDto bookDto = new BookDto();
//        bookDto.setId(book.getId());
//        bookDto.setTitle(book.getTitle());
//        bookDto.setYear(book.getYear());
//        bookDto.setAuthors(book.getAuthors());
//        return bookDto;
//    }
//
//    private Book findBookEntityById(Integer id) {
//        List<Book> books = MyAppApplication.libraryRepository.getBooks();
//        Book result = new Book();
//        for (Book book : books) {
//            if (book.getId().equals(id)) {
//                result = book;
//            }
//        }
//        return result;
//    }
//}

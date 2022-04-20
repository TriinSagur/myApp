package ee.bcs.myApp.library.book;

import org.springframework.stereotype.Service;

@Service
public class BookService {


//    public List<BookDto> findAllBooks() {
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
//    public BookDto addNewBook(BookDto bookDto) {
//        Book book = toEntity(bookDto);
//        book.updateId();
//        List<Book> books = MyAppApplication.libraryRepository.getBooks();
//        books.add(book);
//        return toDto(book);
//
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
//        bookDto.setId(book.getId());
//        bookDto.setTitle(book.getTitle());
//        bookDto.setYear(book.getYear());
//        return bookDto;
//    }


}

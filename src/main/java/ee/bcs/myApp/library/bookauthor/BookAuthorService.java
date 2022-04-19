package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.author.AuthorRepository;
import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookAuthorService {

    @Resource
    private AuthorRepository authorRepository;


    @Resource
    private BookRepository bookRepository;


    @Resource
    private ee.bcs.myApp.library.bookauthor.BookAuthorRepository bookAuthorRepository;

    @Resource
    private BookAuthorMapper bookAuthorMapper;

    public void connectBookWithAuthor(String lastName, String bookName) {
        Author author = authorRepository.getByLastName(lastName);
        Book book = bookRepository.findByTitle(bookName);
        BookAuthor bookAuthor = new BookAuthor();
        bookAuthor.setAuthor(author);
        bookAuthor.setBook(book);
        bookAuthorRepository.save(bookAuthor);
    }

    public void addBookAndAuthor(BookAuthorDto bookAuthorDto) {
    BookAuthor bookAuthor = bookAuthorMapper.toEntity(bookAuthorDto);
    authorRepository.save(bookAuthor.getAuthor());
    bookRepository.save(bookAuthor.getBook());
    bookAuthorRepository.save(bookAuthor);

    }

    public List<BookAuthorDto> getAllBooksAndAuthors() {
        List<BookAuthor> bookAuthors = bookAuthorRepository.findAll();
        return bookAuthorMapper.toDtos(bookAuthors);
    }

    public BookAuthorDto findBookAuthorById(Integer id) {
        BookAuthor bookAuthor = bookAuthorRepository.getById(id);
        return bookAuthorMapper.toDto(bookAuthor);

    }

    public void deleteBookAndAuthor(Integer id) {
       bookAuthorRepository.deleteById(id);
    }




//        Author author = new Author();
//        Book book = new Book();
//        author.setFirstName(bookAuthorDto.getAuthorFirstName());
//        author.setLastName(bookAuthorDto.getAuthorLastName());
//        authorRepository.save(author);
//        book.setTitle(bookAuthorDto.getBookTitle());
//        book.setYear(bookAuthorDto.getBookYear());
//        bookRepository.save(book);
//
//        BookAuthor bookAuthor = new BookAuthor();
//        bookAuthor.setAuthor(author);
//        bookAuthor.setBook(book);
//
//        bookAuthorRepository.save(bookAuthor);



//

//    Author author = authorRepository.getByLastName("Banderas");
//        Book book = bookRepository.findByTitle("Harry Potter");
//        BookAuthor bookAuthor = new BookAuthor();
//        bookAuthor.setAuthor(author);
//        bookAuthor.setBook(book);
//        bookAuthorRepository.save(bookAuthor)
}

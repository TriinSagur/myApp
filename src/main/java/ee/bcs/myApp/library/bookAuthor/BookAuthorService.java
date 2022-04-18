package ee.bcs.myApp.library.bookAuthor;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.author.AuthorDto;
import ee.bcs.myApp.library.author.AuthorRepository;
import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookDto;
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
    private ee.bcs.myApp.library.bookAuthor.BookAuthorRepository bookAuthorRepository;

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

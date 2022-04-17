package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.bank.domain.account.AccountRepository;
import ee.bcs.myApp.library.author.*;
import ee.bcs.myApp.library.book.*;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookAuthorService {
    @Resource
    private BookAuthorRepository bookAuthorRepository;
    @Resource
    private BookAuthorMapper bookAuthorMapper;
    @Resource
    private BookRepository bookRepository;
    @Resource
    private AuthorRepository authorRepository;
    @Resource
    private BookMapper bookMapper;
    @Resource
    private AuthorMapper authorMapper;
    @Resource
    private AuthorService authorService;
    @Resource
    private BookService bookService;




    public BookAuthorDto addNewBookAuthor(Integer bookId, Integer authorId) {


        Book book = bookRepository.getById(bookId);
        Author author = authorRepository.getById(authorId);
        BookAuthor bookAuthor = new BookAuthor();
        bookAuthor.setAuthor(author);
        bookAuthor.setBook(book);
        bookAuthorRepository.save(bookAuthor);
        return bookAuthorMapper.toDto(bookAuthor);
    }


//    public void addNewBookAndAuthor(AuthorDto authorDto,BookDto bookDto) {
//
//        Author author = authorRepository.save(authorMapper.toEntity(authorDto));
//        Book book = bookRepository.save(bookMapper.toEntity(bookDto));
//
//        Author newAuthor = authorMapper.toEntity(authorService.addNewAuthor(authorDto));
//        Book newBook = bookMapper.toEntity(bookService.addNewBook(bookDto));
//
//        BookAuthor bookAuthor = new BookAuthor();
//        bookAuthor.setAuthor(author);
//        bookAuthor.setBook(book);
//        bookAuthorRepository.save(bookAuthor);
//       return bookAuthorMapper.toDto(bookAuthor);
//    }
    
    public List<BookAuthorDto> findAllBookAuthors() {
        List<BookAuthor> all = bookAuthorRepository.findAll();
        return bookAuthorMapper.toDtos(all);
    }
}

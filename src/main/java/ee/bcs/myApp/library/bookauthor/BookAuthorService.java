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




//    @Mapping(target = "bookId", source = "book.id")
//    @Mapping(target = "bookTitle", source = "book.title")
//    @Mapping(target = "bookYear", source = "book.year")
//    @Mapping(target = "authorId", source = "author.id")
//    @Mapping(target = "authorFirstName", source = "author.firstName")
//    @Mapping(target = "authorLastName", source = "author.lastName")
//    public BookAuthorDto addNewBookAndAuthor(AuthorDto authorDto,BookDto bookDto) {
//
//        Author author = authorRepository.save(authorMapper.toEntity(authorDto));
//        Book book = bookRepository.save(bookMapper.toEntity(bookDto));
//        BookAuthor bookAuthor = new BookAuthor();
//        Author newAuthor = authorMapper.toEntity(authorService.addNewAuthor(authorDto));
//        Book newBook = bookMapper.toEntity(bookService.addNewBook(bookDto));
//        bookAuthor.setAuthor(newAuthor);
//        bookAuthor.setBook(newBook);

//
//        BookAuthorDto bookAuthorDto = new BookAuthorDto();
//        bookAuthorDto.setAuthorId(author.getId());
//        bookAuthorDto.setAuthorFirstName(authorDto.getFirstName());
//        bookAuthorDto.setAuthorLastName(authorDto.getLastName());
//        bookAuthorDto.setBookId(book.getId());
//        bookAuthorDto.setBookTitle(bookDto.getTitle());
//        bookAuthorDto.setBookYear(bookDto.getYear());
//
//        bookAuthorRepository.save(bookAuthorMapper.bookAuthorDtoToBookAuthor(bookAuthorDto));
//       return bookAuthorDto;
//    }
    
    public List<BookAuthorDto> findAllBookAuthors() {
        List<BookAuthor> all = bookAuthorRepository.findAll();
        return bookAuthorMapper.toDtos(all);
    }

    public BookAuthorDto findByBookTitle(String bookTitle) {
        BookAuthor bookAuthor = bookAuthorRepository.findByBookTitle(bookTitle);
        return bookAuthorMapper.toDto(bookAuthor);
    }


    public List<BookAuthorDto> findAllBooksByLastName(String lastName) {
        List<BookAuthor> booksByAuthorLastName = bookAuthorRepository.findAllBooksByAuthorLastName(lastName);
        return bookAuthorMapper.toDtos(booksByAuthorLastName);
    }

    public void removeById(Integer id) {
        BookAuthor bookAuthor = bookAuthorRepository.getById(id);
        bookAuthorRepository.delete(bookAuthor);
    }


//
//    @Mapping(target = "bookId", ignore = true)
//    @Mapping(target = "authorId", ignore = true)
    public BookAuthorDto updateById(BookAuthorDto bookAuthorDto, Integer id) {
        BookAuthor bookAuthor = bookAuthorRepository.getById(id);
        bookAuthorDto.setId(id);
        bookAuthorMapper.updateBookAuthorFromBookAuthorDto(bookAuthorDto, bookAuthor);
        bookAuthorRepository.save(bookAuthor);
        return bookAuthorMapper.toDto(bookAuthor);
    }
}

package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.AuthorRepository;
import ee.bcs.myApp.library.book.BookRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookAuthorService {

    @Resource
    private BookAuthorMapper bookAuthorMapper;

    @Resource
    private AuthorRepository authorRepository;

    @Resource
    private BookRepository bookRepository;

    @Resource
    private BookAuthorRepository bookAuthorRepository;


    public void addBookAndAuthor(BookAuthorDto bookAuthorDto) {
        BookAuthor bookAuthor = bookAuthorMapper.toEntity(bookAuthorDto);
        authorRepository.save(bookAuthor.getAuthor());
        bookRepository.save(bookAuthor.getBook());
        bookAuthorRepository.save(bookAuthor);
    }
}

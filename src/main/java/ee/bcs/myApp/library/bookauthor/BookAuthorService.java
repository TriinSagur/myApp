package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.AuthorRepository;
import ee.bcs.myApp.library.book.BookRepository;

import javax.annotation.Resource;

public class BookAuthorService {

    @Resource
    private BookAuthorMapper bookAuthorMapper;

    @Resource
    private AuthorRepository authorRepository;

    @Resource
    private BookRepository bookRepository;

    @Resource
    private BookAuthorRepository bookAuthorRepository;

    public void addBookAuthor(BookAuthorDto bookAuthorDto) {
        BookAuthor bookAuthor = bookAuthorMapper.toEntity(BookAuthorDto);
        authorRepository.save(bookAuthor.getAuthor());
        bookRepository.save(bookAuthor.getBook());
        bookAuthorRepository.save(bookAuthor);

    }
}

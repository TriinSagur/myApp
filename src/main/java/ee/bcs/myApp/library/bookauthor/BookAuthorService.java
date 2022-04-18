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
    private BookauthorRepository bookauthorRepository;

    public void addBookAndAuthor(BookAuthorDto bookAuthorDto){
        BookAuthor bookAuthor = bookAuthorMapper.toEntity(bookAuthorDto);
//        authorRepository.save(bookAuthor.getAuthor());
//        bookRespository.save(bookAuthor.getBook());
//        bookauthorRepository.save(bookAuthor);


    }
}

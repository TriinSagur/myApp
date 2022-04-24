package ee.bcs.myApp.library.service;

import ee.bcs.myApp.library.book.BookDto;
import ee.bcs.myApp.library.bookauthor.BookAuthorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LibraryService {

    @Resource
    private BookAuthorService bookAuthorService;

    public List<BookAuthorResponse> getAllBooksWithAuthors() {
        return bookAuthorService.getAllBooksWithAuthors();
    }

    public List<BookDto> getAllBooksForAuthor(String lastName) {
        return bookAuthorService.getAllBooksForAuthor(lastName);
    }

    public void addBookAndAuthor(BookAuthorRequest bookAuthorDto) {
        bookAuthorService.addBookAndAuthor(bookAuthorDto);
    }

    public void removeAuthorFromBook(Integer bookAuthorId) {
        bookAuthorService.removeAuthorFromBook(bookAuthorId);
    }

    public void addAuthorToBook(Integer bookId, Integer authorId) {
        bookAuthorService.addAuthorToBook(bookId,authorId);
    }
}

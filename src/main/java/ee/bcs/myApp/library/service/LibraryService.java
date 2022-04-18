package ee.bcs.myApp.library.service;

import ee.bcs.myApp.library.author.AuthorDto;
import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookDto;
import ee.bcs.myApp.library.bookauthor.AddBookAuthorDto;
import ee.bcs.myApp.library.bookauthor.BookAuthorResponse;
import ee.bcs.myApp.library.bookauthor.BookAuthorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LibraryService {

    @Resource
    private BookAuthorService bookAuthorService;

    public List<BookAuthorResponse> getAllBookAuthors() {
        return bookAuthorService.getAllBookAuthors();
    }

    public List<BookDto> getAllBooksForAuthor(String lastName) {
        return bookAuthorService.getAllBooksForAuthor(lastName);

    }
}

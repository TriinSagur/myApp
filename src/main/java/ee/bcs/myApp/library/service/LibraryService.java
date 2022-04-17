package ee.bcs.myApp.library.service;

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
}

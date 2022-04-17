package ee.bcs.myApp.library.bookauthor;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookAuthorService {

    @Resource
    private BookAuthorRepository bookAuthorRepository;

    @Resource
    private BookAuthorMapper bookAuthorMapper;


    public List<BookAuthorResponse> getAllBookAuthors() {
        List<BookAuthor> bookAuthors = bookAuthorRepository.findAll();
        return bookAuthorMapper.toBookAuthorResponses(bookAuthors);
    }
}

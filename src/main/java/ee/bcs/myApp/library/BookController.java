package ee.bcs.myApp.library;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BookController {

    @Resource
    private BookService bookService;

    public  Integer addNewBook (@RequestBody BookDto bookDto) {
        return bookService.addNewBook(bookDto);
    }
}

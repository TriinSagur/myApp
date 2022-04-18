package ee.bcs.myApp.library.bookauthor;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/book-author")
public class BookAuthorController {

    @Resource
    private BookAuthorRepository bookAuthorRepository;

    @Resource
    private BookAuthorService bookAuthorService;

    @PostMapping("/book-and-author")
    public void addBookAndAuthor(@RequestBody BookAuthorDto bookAuthorDto) {
        bookAuthorService.addBookAndAuthor(bookAuthorDto);
    }
}

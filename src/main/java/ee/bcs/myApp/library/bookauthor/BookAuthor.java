package ee.bcs.myApp.library.bookauthor;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book-author")
public class BookAuthor {


    @GetMapping
    public void demo(){

    }
}

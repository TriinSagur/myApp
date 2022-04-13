package ee.bcs.myApp.library.book;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/book")

public class BookController {

    @Resource
    public BookService bookService;

    @PostMapping
    @Operation(summary = "lisab uue raamatu")
    public Integer addNewBook(@RequestBody BookDto bookDto){
        return bookService.addNewBook((bookDto));
    }

   /* @GetMapping("/title")
    @Operation(summary = "leian pealkirja  järgi raamatu andmebaasist")
    public Book findBookByTitle(@RequestParam String title){
    return bookService.findBookByTitle(title);}
    }*/


}

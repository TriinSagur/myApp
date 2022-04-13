package ee.bcs.myApp.library.book;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BooksController {

   @Resource private BookService bookService;

   @PostMapping
   @Operation(summary = "Lisab uue raamatu")
   public BookDto addNewBook(@RequestBody BookDto bookDto) {
      return bookService.addNewBook(bookDto);
   }

   @GetMapping("/all")
   @Operation(summary = "Tagastab kõik raamatud")
   public List<BookDto> getAllBooks() {
      return bookService.findAllBooks();
   }

   @GetMapping("/id")
   @Operation(summary = "Tagastab raamatu id järgi")
   public BookDto findBookById(@RequestParam Integer id) {
      return bookService.findBookById(id);
   }

   @DeleteMapping("/id")
   @Operation(summary = "Kustutab raamatu id järgi")
   public void deleteBookById(@RequestParam Integer id) {
      bookService.deleteBookById(id);
   }

   @PostMapping("/id")
   @Operation(summary = "Uuendab raamatut id järgi")
   public void updateBooksById(@RequestParam Integer id, @RequestParam BookDto bookDto) {
      bookService.updateBooksById(id, bookDto);
   }







}

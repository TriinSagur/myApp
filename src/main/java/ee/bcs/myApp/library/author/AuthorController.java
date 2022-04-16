package ee.bcs.myApp.library.book;
import ee.bcs.myApp.bank.domain.customer.Customer;
import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.author.AuthorDto;
import ee.bcs.myApp.library.author.AuthorRepository;
import ee.bcs.myApp.library.author.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Resource
    private AuthorService authorService;
    @Resource
    AuthorRepository authorRepository;


    @PostMapping
    @Operation(summary = "Lisab uue autori")
    public AuthorDto addNewAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.addNewAuthor(authorDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Tagastab autorite nimekirja")
    public List<AuthorDto> getAllBooks() {

        return authorService.returnAllAuthors();
    }

    @GetMapping(("/id"))
    @Operation(summary = "Leiab autori id alusel.")

    public AuthorDto findBookById(@RequestParam Integer id) {
        return authorService.findAuthorById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Kustutab ID järgi autori")
    public void removeAuthorById(@RequestParam Integer id) {

        authorService.removeAuthorById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Uuendab klienti ID järgi")
    public void updateBookById(@RequestParam Integer id, @Valid @RequestBody AuthorDto authorDto) {
        authorService.updateAuthorById(id, authorDto);
    }

}

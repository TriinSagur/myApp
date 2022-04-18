package ee.bcs.myApp.library.author;

import ee.bcs.myApp.library.book.Book;
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

    @PostMapping
    @Operation(summary = "Lisab uue autori.")
    public AuthorDto addNewAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.addNewAuthor(authorDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Tagastab kõik autorid")
    public List<AuthorDto> findAllAuthors() {
        return authorService.findAllAuthors();
    }

    @GetMapping("/id")
    @Operation(summary = "Leiab andmebaasi id järgi autori.")
    public AuthorDto findAuthorById(@RequestParam Integer id) {
        return authorService.findAuthorById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Kustutab andmebaasi id järgi autori.")
    public void removeAuthorById(@RequestParam Integer id) {
        authorService.removeAuthorById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Uuendab andmebaasi id järgi autorit.")
    public void updateAuthorById(@RequestParam Integer id, @Valid @RequestBody AuthorDto authorDto) {
        authorService.updateAuthorById(id, authorDto);
    }

}

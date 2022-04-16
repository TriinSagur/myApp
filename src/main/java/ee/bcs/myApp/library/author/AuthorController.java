package ee.bcs.myApp.library.author;

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
    @Operation(summary = "Lisab andmebaasi uue autori.")
    public AuthorDto addNewAuthor(@Valid @RequestBody AuthorDto authorDto) {
        return authorService.addNewAuthor(authorDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Kuvab andmebaasist kõik autorid")
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/id")
    @Operation(summary = "Leiab andmebaasi id järgi autori")
    public AuthorDto findAuthorById(@RequestParam Integer id) {
        return authorService.findAuthorById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Kustutab andmebaasist id järgi autori")
    public void removeAuthorById(@RequestParam Integer id) {
        authorService.removeAuthorById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "uuendab andmebaasi id järgi autori")
    public void updateAuthorById(@RequestParam Integer id, @RequestBody AuthorDto authorDto) {
        authorService.updateAuthorById(id, authorDto);

    }

}

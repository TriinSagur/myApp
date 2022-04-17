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

    @PostMapping("/add")
    @Operation(summary = "Lisab autori")
    public AuthorDto addNewAuthor(@Valid @RequestBody AuthorDto authorDto) {
        return authorService.addNewAuthor(authorDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Kõik autorid")
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/id")
    @Operation(summary = "Autori otsimine ID kaudu")
    public AuthorDto findAuthorById(@RequestParam Integer id) {
        return authorService.findAuthorById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Autori eemaldamine ID kaudu")
    public void removeAuthorById(@RequestParam Integer id) {
        authorService.removeAuthorById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Autori andmete uuendamine ID kaudu")
    public void updateAuthorById(@RequestParam Integer id, @Valid @RequestBody AuthorDto authorDto) {
        authorService.updateAuthorById(id, authorDto);
    }

}

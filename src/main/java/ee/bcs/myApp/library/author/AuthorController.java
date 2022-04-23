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

    @GetMapping("/find-all")
    @Operation(summary = "Leiab kõik autorid")
    public List<AuthorDto> getAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping("/find-byId")
    @Operation(summary = "Leiab autori ID järgi")
    public AuthorDto getAuthorById(@RequestParam Integer id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping("/new")
    @Operation(summary = "Lisab uue autori")
    public AuthorDto addNewAuthor(@Valid @RequestBody Author author) {
        return authorService.addNewAuthor(author);
    }

    @DeleteMapping("/delete-byLastName")
    @Operation(summary = "Kustutab autori tema perekonnanime järgi")
    public void deleteAuthorByLastName(@RequestParam String lastName) {
        authorService.deleteAuthorByLastName(lastName);
    }

    @PutMapping("/update-byId")
    @Operation(summary = "Uuendab autorit eesnime järgi")
    public void updateAuthorById(@RequestParam Integer id, @RequestBody AuthorDto authorDto) {
        authorService.updateAuthorById(id, authorDto);
    }

}

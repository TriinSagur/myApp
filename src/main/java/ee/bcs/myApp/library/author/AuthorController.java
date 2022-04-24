package ee.bcs.myApp.library.author;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Resource
    private AuthorService authorService;

    @PostMapping
    @Operation(summary = "Lisab uue autori")
    public AuthorDto addNewAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.addNewAuthor(authorDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Tagastab kõik autorid")
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/id")
    @Operation(summary = "Leiab autori id järgi")
    public AuthorDto findAuthorById(@RequestParam Integer id) {
        return authorService.findAuthorById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Kustutab autori id järgi")
    public void removeAuthorById(@RequestParam Integer id) {
        authorService.removeAuthorById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Uuendab autori id järgi")
    public void updateAuthorById (@RequestParam Integer id, @RequestBody AuthorDto authorDto) {
        authorService.updateAuthorById(id, authorDto);
    }

}

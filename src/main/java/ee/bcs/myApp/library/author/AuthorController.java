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
    @Operation(summary = "Add new author")
    public AuthorDto addNewAuthor(@Valid @RequestBody AuthorDto authorDto) {
        return authorService.addNewAuthor(authorDto);
    }

    @GetMapping ("/all")
    @Operation(summary = "Get list of all authors")
    public List<AuthorDto> findAllAuthors() {
        return authorService.findAllAuthors();
    }

    @GetMapping("/id")
    @Operation(summary = "Find author by ID")
    public AuthorDto findAuthorById( @RequestParam Integer id) {
        return authorService.findAuthorById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Delete author by ID")
    public void removeAuthorById(@RequestParam Integer id) {
        authorService.removeAuthorById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Update author data by ID")
    public void updateAuthorById(@RequestParam Integer id,@RequestBody AuthorDto authorDto) {
        authorService.updateAuthorById(id, authorDto);
    }

}

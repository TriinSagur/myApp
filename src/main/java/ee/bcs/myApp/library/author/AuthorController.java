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

    @PostMapping("/new")
    @Operation (summary = "lisab uue autori")
    public AuthorDto addNewAuthor (@RequestBody AuthorDto authorDto) {
        return authorService.addNewAuthor(authorDto);
    }

    @GetMapping("/all")
    @Operation(summary = "leiab koik autorid")
    public List<AuthorDto> findAllAuthors () {
        return authorService.findAllAuthors();
    }

    @GetMapping("/id")
    @Operation(summary = "leiab autori id jargi")
    public AuthorDto findAuthorById (@RequestParam Integer id) {
        return authorService.findAuthorById(id);
    }


    @GetMapping("/by-lastname")
    @Operation(summary = "leiab autori perekonnanime jargi")
    public AuthorDto findAuthorByLastName (@RequestParam String lastName) {
        return authorService.findAuthorByLastName(lastName);
    }

    @DeleteMapping("/by-lastname")
    @Operation(summary = "kustutab autori perekonnanime jargi")
    public String deleteAuthorByLastName (@RequestParam String lastName) {
       return authorService.deleteAuthorByLastName(lastName);
    }

    @PutMapping("/updateauthor")
    @Operation(summary = "uuendab autori id jargi")
    public void updateAuthorById(@RequestParam Integer id,@RequestBody AuthorDto authorDto) {
        authorService.updateAuthorById(id, authorDto);
    }
}

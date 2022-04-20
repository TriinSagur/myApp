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

    @PostMapping()
    @Operation(summary = "Lisab uue autori")
    public AuthorDto addNewAuthor(@RequestBody @Valid AuthorDto authorDto) {
        return authorService.addNewAuthor(authorDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Näitab kõiki autoreid")
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/id")
    @Operation(summary = "Leiab autori ID järgi")
    public AuthorDto findAuthorById(@RequestParam Integer id) {
        return authorService.findAuthorById(id);

    }




}

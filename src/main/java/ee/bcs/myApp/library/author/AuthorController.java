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

    @PostMapping("/add-new")
    @Operation(summary = "Lisab uue autori")
    public AuthorDto addNewAuthor(@RequestBody @Valid AuthorDto authorDto) {
        return authorService.addNewAuthor(authorDto);
    }

    @GetMapping("/id")
    @Operation(summary = "Otsib autori ID kaudu")
    public AuthorDto findAuthorById(@RequestParam Integer id) {
        return authorService.findAuthorById(id);
    }

    @GetMapping ("/find-all")
    @Operation(summary = "Näitab kõik autorid")
    public List<AuthorDto> findAllAuthors() {

        return authorService.findAllAuthors();
    }


}

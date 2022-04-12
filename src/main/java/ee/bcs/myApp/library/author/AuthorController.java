package ee.bcs.myApp.library.author;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Resource
    private AuthorService authorService;

    @PostMapping
    @Operation(summary = "Lisab uue raamatu")
    public AuthorDto addNewAuthor(@RequestBody @Valid AuthorDto authorDto) {
        return authorService.addNewAuthor(authorDto);
    }
}

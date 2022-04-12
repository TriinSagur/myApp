package ee.bcs.myApp.library.author;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Resource
    AuthorService authorService;

    @PostMapping
    @Operation(summary = "Lisab uue autori")
    public AuthorDto addNewAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.addNewAuthor(authorDto);
    }




}

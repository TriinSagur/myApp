package ee.bcs.myApp.library.author;

import ee.bcs.myApp.MyAppApplication;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Resource
    private AuthorService authorService;

    @PostMapping
    @Operation(summary = "Lisab uue autori.")
    public AuthorDto addNewAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.addNewAuthor(authorDto);
    }
}

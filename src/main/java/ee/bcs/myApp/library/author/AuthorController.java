package ee.bcs.myApp.library.author;

import ee.bcs.myApp.bank.account.AccountDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Resource
    private AuthorService authorService;

    public AuthorDto addNewAuthor (@RequestBody @Valid AuthorDto authorDto){
        return authorService.addNewAuthor(authorDto);

    }

    @GetMapping
    public List<AuthorDto> findAllAuthors() {

        return authorService.findAllAuthors();
    }


}

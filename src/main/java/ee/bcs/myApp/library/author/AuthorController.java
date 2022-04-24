package ee.bcs.myApp.library.author;

import ee.bcs.myApp.bank.domain.customer.CustomerDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Resource
    private AuthorService authorService;

    @PostMapping("/add")
    @Operation(summary = "andmebaasi lisatakse uus autor")
    public AuthorDto addNewAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.addNewAuthor(authorDto);
    }

    @GetMapping("/all")
    @Operation(summary = "andmbaasi päring tagastab kõik autorid")
    public List<AuthorDto> getAllAuthors() {

        return authorService.getAllAuthors();
    }

    @GetMapping("/id")
    @Operation(summary = "otsib andmebaasist autorit etteantud ID järgi")
    public AuthorDto findAuthorById(@RequestParam Integer id) {
        return authorService.findAuthorById(id);
    }
    @GetMapping("lastName")
    @Operation(summary = "otsib andmebaasist autorit etteantud perenime järgi")
    public AuthorDto findAuthorByLastName(@RequestParam String lastName) {
        return authorService.findAuthorByLastName(lastName);
    }

    @DeleteMapping("/id")
    @Operation(summary = "kustutab andmebaasist autori etteantud ID järgi")
    public void removeAuthorById(@RequestParam Integer id) {
        authorService.removeAuthorById(id);
    }


    @PutMapping("/id")
    @Operation(summary = "uuendab andmebaasi ID järgi autori andmeid")
    public void updateCustomerById(@RequestParam Integer id, @Valid @RequestBody AuthorDto authorDto) {
        authorService.updateAuthorById(id, authorDto);
    }

    @PutMapping("/lastName")
    @Operation(summary = "uuendab andmebaasi perenime järgi autori andmeid")
    public void updateCustomerByLastName(@RequestParam String lastName, @Valid @RequestBody AuthorDto authorDto) {
        authorService.updateAuthorByLastName(lastName, authorDto);
    }

    @DeleteMapping("/lastName")
    @Operation(summary = "kustutab andmebaasist autori, etteantud perenime järgi")
    public void removeAuthorByLastName(@RequestParam String lastName) {
        authorService.removeAuthorByLastName(lastName);
    }
}

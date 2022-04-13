//package ee.bcs.myApp.library;
//
//import io.swagger.v3.oas.annotations.Operation;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
//@RestController
//@RequestMapping("/author")
//public class AuthorController {
//
//    @Resource
//    private AuthorService authorService;
//
//    @PostMapping("/id")
//    @Operation(summary = "Lisab autori")
//    public Integer addNewAuthor(@RequestBody AuthorDto authorDto) {
//        return authorService.addNewAuthor(authorDto);
//    }
//}

package ee.bcs.myApp.library.author;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping
@RestController
public class AuthorController {

    @Resource
    private AuthorService authorService;
}

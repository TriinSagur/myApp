package ee.bcs.myApp.library.keyword;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/keyword")
public class KeywordController {

    @Resource
    private KeywordService keywordService;

    @PostMapping
    @Operation(summary = "Add new keyword")
    public KeywordDto addNewKeyword (@RequestBody @Valid KeywordDto keywordDto) {
       return keywordService.addNewKeyword(keywordDto);
    }
}

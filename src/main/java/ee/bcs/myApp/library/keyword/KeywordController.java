package ee.bcs.myApp.library.keyword;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    @Operation(summary = "Update by ID")
    public void updateById(@RequestParam Integer id, @RequestBody KeywordDto keywordDto) {
        keywordService.updateById(id, keywordDto);
    }

    @DeleteMapping
    @Operation(summary = "Delete from list by ID")
    public void removeById (@RequestParam Integer id) {
        keywordService.removeById(id);
    }
}

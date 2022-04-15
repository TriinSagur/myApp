package ee.bcs.myApp.library.keyword;

import ee.bcs.myApp.library.keyword.KeywordDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/keyword")
public class KeywordController {
    @Resource
    private KeywordService keywordService;

    @PostMapping
    @Operation(summary = "Add new keyword")
    public KeywordDto addNewKeyword(@Valid @RequestBody KeywordDto keywordDto) {
        return keywordService.addNewKeyword(keywordDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Get list of all keywords")
    public List<KeywordDto> findAllKeywords() {
        return keywordService.findAllKeywords();
    }

    @GetMapping("/id")
    @Operation(summary = "Find keyword by ID")
    public KeywordDto findKeywordById( @RequestParam Integer id) {
        return keywordService.findKeywordById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Delete keyword by ID")
    public void removeKeywordById(@RequestParam Integer id) {
        keywordService.removeKeywordById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Update keyword data by ID")
    public void updateKeywordById(@RequestParam Integer id,@RequestBody KeywordDto keywordDto) {
        keywordService.updateKeywordById(id, keywordDto);
    }

}

package ee.bcs.myApp.library.keyword;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/keyword")
public class KeywordController {

    @Resource
    private KeywordService keywordService;

    @PostMapping
    @Operation(summary = "lisab uue märksõna")
    public KeywordDto addNewKeyword(@RequestBody KeywordDto keywordDto) {
        return keywordService.addNewKeyword(keywordDto);
    }

    @GetMapping("/all")
    @Operation(summary = "tagastab kõik märksõnad")
    public List<KeywordDto> getAllKeywords() {
        return keywordService.getAllKeywords();
    }

    @GetMapping("/id")
    @Operation(summary = "tagastab märksõnad id järgi")
    public KeywordDto findKeywordById(@RequestParam Integer id) {
        return keywordService.findKeywordById(id);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "kustutab märksõna id järgi")
    public void deleteKeywordById(@RequestParam Integer id) {
        keywordService.deleteKeywordById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "uuendab märksõna id järgi")
    public void updateKeywordById(@RequestParam Integer id, @RequestBody KeywordDto keywordDto) {
        keywordService.updateKeywordById(id, keywordDto);
    }

}

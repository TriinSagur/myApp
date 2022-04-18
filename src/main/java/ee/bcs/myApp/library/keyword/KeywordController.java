package ee.bcs.myApp.library.keyword;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/keywords")
public class KeywordController {

    @Resource
    private KeywordService keywordService;


    @PostMapping("/add")
    @Operation(summary = "Lisab")
    public KeywordDto addNewKeyword(@RequestBody KeywordDto keywordDto) {
        return keywordService.addNewKeyword(keywordDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Leiab kõik")
    public List<KeywordDto> getAllKeywords() {
        return keywordService.getAllKeywords();
    }

    @GetMapping("/id")
    @Operation(summary = "Leiab id kaudu")
    public KeywordDto findKeywordById(@RequestParam Integer id) {
        return keywordService.findKeywordById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Eemaldab id kaudu")
    public void removeKeywordById(@RequestParam Integer id) {
        keywordService.removeKeywordById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Uuendab id kaudu")
    public void updateKeywordById(@RequestParam Integer id, @RequestBody KeywordDto keywordDto) {
        keywordService.updateKeywordById(id, keywordDto);
    }
}

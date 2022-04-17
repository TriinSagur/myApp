package ee.bcs.myApp.library.keyword;

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
    @Operation(summary = "Lisab uue keywordi")
    public KeywordDto addNewKeyword(@RequestBody @Valid KeywordDto keywordDto) {
        return keywordService.addNewKeyword(keywordDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Tagastab kõik keywordid")
    public List<KeywordDto> getAllKeywords() {
        return keywordService.getAllKeywords();
    }

    @GetMapping("/id")
    @Operation(summary = "Leiab keywordi id järgi")
    public KeywordDto findKeywordById(@RequestParam Integer id) {
        return keywordService.findKeywordById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Kustutab keywordi id järgi")
    public void removeKeywordById(@RequestParam Integer id) {
        keywordService.removeKeywordById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Uuendab keywordi id järgi")
    public void updateKeywordById(@RequestParam Integer id, @RequestBody KeywordDto keywordDto) {
        keywordService.updateKeywordById(id, keywordDto);
    }
}
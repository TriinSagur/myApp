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
    @Operation(summary = "Lisab uue võtmesõna")
    public KeywordDto addNewKeyword(@RequestParam KeywordDto keywordDto) {
        return keywordService.addNewKeyword(keywordDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Tagastab kõik võtmesõnad")
    public List<KeywordDto> getAllKeywords() {
        return keywordService.getAllKeywords();
    }

    public void removeKeywordById(Integer id) {
        keywordService.removeKeywordById(id);
    }

}

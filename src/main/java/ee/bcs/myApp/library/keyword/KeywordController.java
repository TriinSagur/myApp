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

    @GetMapping("/all")
    @Operation(summary = "Tagastab kõik keywordid")
    public List<KeywordDto> findAllKeywords() {
        return keywordService.findAllKeywords();
    }

    @GetMapping("/id")
    @Operation(summary = "Tagastab keywordi id järgi")
    public KeywordDto findById(@RequestParam Integer id) {
        return keywordService.findById(id);
    }

    @PostMapping("/add")
    @Operation(summary = "Lisab uue keywordi")
    public KeywordDto addNewKeyword(@RequestBody KeywordDto keywordDto) {
        return keywordService.addNewKeyword(keywordDto);
    }
}

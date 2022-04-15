package ee.bcs.myApp.library.keyword;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

package ee.bcs.myApp.library.keyword;


import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class KeywordController {

    @Resource
    private KeywordService keywordService;

    public KeywordDto addNewKeyword ()
}

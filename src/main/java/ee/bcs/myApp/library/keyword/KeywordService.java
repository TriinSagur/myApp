package ee.bcs.myApp.library.keyword;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class KeywordService {

    @Resource
    private KeywordRepository keywordRepository;

    @Resource
    private KeywordMapper keywordMapper;


    public List<KeywordDto> findAllKeywords() {
        List<Keyword> keywords = keywordRepository.findAll();
        List<KeywordDto> keywordDtos = keywordMapper.toDtos(keywords);
        return keywordDtos;
    }
}


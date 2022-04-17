package ee.bcs.myApp.library.keyword;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class KeywordService {

    @Resource
    private KeywordMapper keywordMapper;

    @Resource
    private KeywordRepository keywordRepository;


    public KeywordDto addNewKeyword(KeywordDto keywordDto) {
        Keyword keyword = keywordMapper.toEntity(keywordDto);
        keywordRepository.save(keyword);
        return keywordMapper.toDto(keyword);
    }

    public List<KeywordDto> getAllKeywords() {
        List<Keyword> keywords = keywordRepository.findAll();
        return keywordMapper.toDtos(keywords);
    }

    public void removeKeywordById(Integer id) {
        keywordRepository.deleteById(id);
    }
}

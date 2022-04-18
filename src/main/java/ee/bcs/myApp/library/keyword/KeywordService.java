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
        List<Keyword> allKeywords = keywordRepository.findAll();
        return keywordMapper.toDtos(allKeywords);
    }

    public KeywordDto findKeywordById(Integer id) {
        Keyword keyword = keywordRepository.getById(id);
        return keywordMapper.toDto(keyword);
    }

    public void deleteKeywordById(Integer id) {
        keywordRepository.deleteById(id);

    }

    public void updateKeywordById(Integer id, KeywordDto keywordDto) {
        Keyword keyword = keywordRepository.getById(id);
        keywordMapper.updateEntity(keywordDto, keyword);
        keywordRepository.save(keyword);
    }
}

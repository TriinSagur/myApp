package ee.bcs.myApp.library.keyword;

import ee.bcs.myApp.library.keyword.Keyword;
import ee.bcs.myApp.library.keyword.KeywordDto;
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

    public List<KeywordDto> findAllKeywords() {
        List<Keyword> keywords = keywordRepository.findAll();
        return keywordMapper.toDtos(keywords);
    }

    public KeywordDto findKeywordById(Integer id) {
        Keyword keyword = keywordRepository.getById(id);
        return keywordMapper.toDto(keyword);
    }

    public void removeKeywordById(Integer id) {
        keywordRepository.deleteById(id);
    }

    public void updateKeywordById(Integer keywordId, KeywordDto keywordDto) {
        Keyword keyword = keywordRepository.getById(keywordId);
        keywordMapper.updateEntity(keywordDto,keyword);
        keywordRepository.save(keyword);
    }
}

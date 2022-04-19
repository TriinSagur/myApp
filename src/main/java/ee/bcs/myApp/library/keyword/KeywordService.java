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

    public void updateById(Integer id, KeywordDto keywordDto) {
        Keyword keyword = keywordRepository.getById(id);
        keywordMapper.updateKeywordFromKeywordDto(keywordDto, keyword);
        keywordRepository.save(keyword);
    }

    public void removeById(Integer id) {
        keywordRepository.deleteById(id);
    }

    public List<KeywordDto> findAllKeywords() {
        List<Keyword> all = keywordRepository.findAll();
        return keywordMapper.toDtos(all);
    }
}

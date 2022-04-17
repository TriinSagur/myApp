package ee.bcs.myApp.library.keyword;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}

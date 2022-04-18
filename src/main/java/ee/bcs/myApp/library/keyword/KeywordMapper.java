package ee.bcs.myApp.library.keyword;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface KeywordMapper {
    Keyword keywordDtoToKeyword(KeywordDto keywordDto);

    KeywordDto keywordToKeywordDto(Keyword keyword);

    List<KeywordDto> keywordToKeywordDtos(List<Keyword> keywords);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateKeywordFromKeywordDto(KeywordDto keywordDto, @MappingTarget Keyword keyword);
}

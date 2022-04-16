package ee.bcs.myApp.library.keyword;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface KeywordMapper {
    Keyword keywordDtoToKeyword(KeywordDto keywordDto);

    KeywordDto keywordToKeywordDto(Keyword keyword);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateKeywordFromKeywordDto(KeywordDto keywordDto, @MappingTarget Keyword keyword);
}

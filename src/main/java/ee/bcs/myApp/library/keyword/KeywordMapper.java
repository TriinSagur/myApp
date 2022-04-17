package ee.bcs.myApp.library.keyword;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface KeywordMapper {
    Keyword toEntity(KeywordDto keywordDto);

    KeywordDto toDto(Keyword keyword);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateKeywordFromKeywordDto(KeywordDto keywordDto, @MappingTarget Keyword keyword);
}

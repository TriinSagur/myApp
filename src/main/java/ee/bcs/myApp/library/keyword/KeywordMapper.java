package ee.bcs.myApp.library.keyword;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface KeywordMapper {
    Keyword toEntity(KeywordDto keywordDto);

    KeywordDto toDto(Keyword keyword);

    List<KeywordDto> toDtos(List<Keyword> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateKeywordFromKeywordDto(KeywordDto keywordDto, @MappingTarget Keyword keyword);
}

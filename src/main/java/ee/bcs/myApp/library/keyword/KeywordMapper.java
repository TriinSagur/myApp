package ee.bcs.myApp.library.keyword;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface KeywordMapper {
    @Mapping(target = "id", ignore = true)
    Keyword toEntity(KeywordDto keywordDto);

    KeywordDto toDto(Keyword keyword);

    List<KeywordDto> toDtos(List<Keyword> keywords);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateKeywordFromKeywordDto(KeywordDto keywordDto, @MappingTarget Keyword keyword);
}

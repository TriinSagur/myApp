package ee.bcs.myApp.library.bookkeyword;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookKeywordMapper {
    BookKeyword bookKeywordDtoToBookKeyword(BookKeywordDto bookKeywordDto);

    BookKeywordDto bookKeywordToBookKeywordDto(BookKeyword bookKeyword);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookKeywordFromBookKeywordDto(BookKeywordDto bookKeywordDto, @MappingTarget BookKeyword bookKeyword);
}

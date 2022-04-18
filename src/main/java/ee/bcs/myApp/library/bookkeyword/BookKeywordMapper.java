package ee.bcs.myApp.library.bookkeyword;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookKeywordMapper {
    @Mapping(source = "bookId", target = "book.id")
    @Mapping(source = "bookTitle", target = "book.title")
    @Mapping(source = "bookYear", target = "book.year")
    @Mapping(source = "keywordId", target = "keyword.id")
    BookKeyword toEntity(BookKeywordDto bookKeywordDto);

    @InheritInverseConfiguration(name = "toEntity")
    BookKeywordDto toDto(BookKeyword bookKeyword);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookKeywordFromBookKeywordDto(BookKeywordDto bookKeywordDto, @MappingTarget BookKeyword bookKeyword);
}

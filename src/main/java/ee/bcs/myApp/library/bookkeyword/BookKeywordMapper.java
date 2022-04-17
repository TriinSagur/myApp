package ee.bcs.myApp.library.bookkeyword;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookKeywordMapper {
    @Mapping(source = "bookId", target = "book.id")
    @Mapping(source = "bookTitle", target = "book.title")
    @Mapping(source = "bookYear", target = "book.year")
    BookKeyword bookKeywordDtoToBookKeyword(BookKeywordDto bookKeywordDto);

    @InheritInverseConfiguration(name = "bookKeywordDtoToBookKeyword")
    BookKeywordDto toDto(BookKeyword bookKeyword);

    @InheritConfiguration(name = "bookKeywordDtoToBookKeyword")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookKeywordFromBookKeywordDto(BookKeywordDto bookKeywordDto, @MappingTarget BookKeyword bookKeyword);
}

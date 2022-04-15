package ee.bcs.myApp.library.bookkeyword;

import org.mapstruct.*;

import java.sql.ClientInfoStatus;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookKeywordMapper {
    @Mapping(source = "bookId", target = "book.id")
    @Mapping(source = "bookTitle", target = "book.title")
    @Mapping(source = "bookYear", target = "book.year")
    @Mapping(source = "keywordId", target = "keyword.id")
    @Mapping(source = "keywordName", target = "keyword.name")
    BookKeyword toEntity(BookKeywordDto bookKeywordDto);

    @InheritInverseConfiguration(name = "toEntity")
    BookKeywordDto toDto(BookKeyword bookKeyword);

    List<BookKeywordDto> toDtos(List<BookKeyword> bookKeywords);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(BookKeywordDto bookKeywordDto, @MappingTarget BookKeyword bookKeyword);
}

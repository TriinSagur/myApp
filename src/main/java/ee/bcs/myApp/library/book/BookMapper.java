package ee.bcs.myApp.library.book;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookMapper {
    Book toBookEntity(BookDto bookDto);

    BookDto toBookDto(Book book);

    List<BookDto> toDtos(List<Book> books);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(BookDto bookDto, @MappingTarget Book book);
}

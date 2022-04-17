package ee.bcs.myApp.library.book;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "id", ignore = true)
    Book bookToEntity(BookDto bookDto);

    BookDto bookToDto(Book book);

    List<BookDto> toDtos (List<Book> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateBookFromBookDto(BookDto bookDto, @MappingTarget Book book);
}

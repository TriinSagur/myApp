package ee.bcs.myApp.library.book;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookMapper {
    Book bookToEntity(BookDto bookDto);

    BookDto bookToDto(Book book);

    List<BookDto> toDtos (List<Book> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookFromBookDto(BookDto bookDto, @MappingTarget Book book);
}

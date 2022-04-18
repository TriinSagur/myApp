package ee.bcs.myApp.library.book;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookMapper {
    Book bookDtoToBook(BookDto bookDto);

    BookDto bookToBookDto(Book book);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookFromBookDto(BookDto bookDto, @MappingTarget Book book);
}

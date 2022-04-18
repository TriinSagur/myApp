package ee.bcs.myApp.library.book;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookMapper {
    Book bookDtoToBook(BookDto bookDto);

    BookDto bookToBookDto(Book book);

    List<BookDto> bookToBookDtos(List<Book> books);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookFromBookDto(BookDto bookDto, @MappingTarget Book book);

}

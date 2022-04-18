package ee.bcs.myApp.library.book;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.author.AuthorDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookMapper {
    Book toEntity(BookDto bookDto);

    BookDto toDto(Book book);

    List<BookDto> toDtos(List<Book> entities);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(BookDto bookDto, @MappingTarget Book book);
}

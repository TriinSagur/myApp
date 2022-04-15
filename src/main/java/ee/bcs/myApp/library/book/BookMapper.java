package ee.bcs.myApp.library.book;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "id", ignore = true)
    Book toEntity(BookDto bookDto);


    BookDto toDto(Book book);
    List<BookDto> toDtos (List<Book> books);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(BookDto bookDto, @MappingTarget Book book);
}

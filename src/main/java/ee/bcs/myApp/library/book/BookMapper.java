package ee.bcs.myApp.library.book;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookMapper {
    Book toEntity(BookDto bookDto);

    BookDto toDto(Book book);

    // et tagastada kõik raamatud on vaja listi
    List<BookDto> toDtos(List<Book> books);



    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(BookDto dto, @MappingTarget Book entity);
}

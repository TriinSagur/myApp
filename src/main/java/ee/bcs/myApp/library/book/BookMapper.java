package ee.bcs.myApp.library.book;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookMapper {

    Book toEntity(NewBookRequest newBookRequest);

    NewBookRequest toDto(Book book);

    List <NewBookRequest> toDtos(List <Book> books);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookFromBookDto(NewBookRequest newBookRequest, @MappingTarget Book book);
}

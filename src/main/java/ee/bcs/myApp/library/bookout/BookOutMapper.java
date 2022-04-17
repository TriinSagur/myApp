package ee.bcs.myApp.library.bookout;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookOutMapper {
    @Mapping(source = "bookId", target = "book.id")
    @Mapping(source = "bookTitle", target = "book.title")
    @Mapping(source = "bookYear", target = "book.year")
    BookOut toEntity(BookOutDto bookOutDto);

    @InheritInverseConfiguration(name = "toEntity")
    BookOutDto toDto(BookOut bookOut);

    List<BookOutDto> toDtos(List<BookOut> bookOut);


    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(BookOutDto bookOutDto, @MappingTarget BookOut bookOut);
}

package ee.bcs.myApp.library.bookkeyword;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookOutMapper {
    @Mapping(source = "bookId", target = "book.id")
    @Mapping(source = "bookTitle", target = "book.title")
    @Mapping(source = "bookYear", target = "book.year")
    BookOut bookOutDtoToBookOut(BookOutDto bookOutDto);

    @InheritInverseConfiguration(name = "bookOutDtoToBookOut")
    BookOutDto bookOutToBookOutDto(BookOut bookOut);

    @InheritConfiguration(name = "bookOutDtoToBookOut")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookOutFromBookOutDto(BookOutDto bookOutDto, @MappingTarget BookOut bookOut);
}

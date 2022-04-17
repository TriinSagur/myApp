package ee.bcs.myApp.library.bookauthor;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookAuthorMapper {
    BookAuthor bookAuthorDtoToBookAuthor(BookAuthorDto bookAuthorDto);

    BookAuthorDto bookAuthorToBookAuthorDto(BookAuthor bookAuthor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookAuthorFromBookAuthorDto(BookAuthorDto bookAuthorDto, @MappingTarget BookAuthor bookAuthor);
}

package ee.bcs.myApp.library.bookout;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookOutMapper {
    BookOut bookOutDtoToBookOut(BookOutDto bookOutDto);

    BookOutDto bookOutToBookOutDto(BookOut bookOut);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookOutFromBookOutDto(BookOutDto bookOutDto, @MappingTarget BookOut bookOut);
}

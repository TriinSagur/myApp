package ee.bcs.myApp.library.keyword;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-18T13:00:31+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (JetBrains s.r.o.)"
)
@Component
public class KeywordMapperImpl implements KeywordMapper {

    @Override
    public Keyword toEntity(KeywordDto keywordDto) {
        if ( keywordDto == null ) {
            return null;
        }

        Keyword keyword = new Keyword();

        keyword.setId( keywordDto.getId() );
        keyword.setName( keywordDto.getName() );

        return keyword;
    }

    @Override
    public KeywordDto toDto(Keyword keyword) {
        if ( keyword == null ) {
            return null;
        }

        Integer id = null;
        String name = null;

        id = keyword.getId();
        name = keyword.getName();

        KeywordDto keywordDto = new KeywordDto( id, name );

        return keywordDto;
    }

    @Override
    public List<Keyword> toEntities(List<KeywordDto> keywordDto) {
        if ( keywordDto == null ) {
            return null;
        }

        List<Keyword> list = new ArrayList<Keyword>( keywordDto.size() );
        for ( KeywordDto keywordDto1 : keywordDto ) {
            list.add( toEntity( keywordDto1 ) );
        }

        return list;
    }

    @Override
    public List<KeywordDto> toDtos(List<Keyword> keyword) {
        if ( keyword == null ) {
            return null;
        }

        List<KeywordDto> list = new ArrayList<KeywordDto>( keyword.size() );
        for ( Keyword keyword1 : keyword ) {
            list.add( toDto( keyword1 ) );
        }

        return list;
    }

    @Override
    public void updateKeywordFromKeywordDto(KeywordDto keywordDto, Keyword keyword) {
        if ( keywordDto == null ) {
            return;
        }

        if ( keywordDto.getId() != null ) {
            keyword.setId( keywordDto.getId() );
        }
        if ( keywordDto.getName() != null ) {
            keyword.setName( keywordDto.getName() );
        }
    }
}

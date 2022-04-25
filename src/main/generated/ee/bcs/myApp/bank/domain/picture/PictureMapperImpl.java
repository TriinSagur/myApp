package ee.bcs.myApp.bank.domain.picture;

import ee.bcs.myApp.bank.service.image.ImageResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-25T15:42:20+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class PictureMapperImpl implements PictureMapper {

    @Override
    public ImageResponse toResponse(Picture picture) {
        if ( picture == null ) {
            return null;
        }

        ImageResponse imageResponse = new ImageResponse();

        imageResponse.setData( PictureMapper.byteArrayToString( picture.getData() ) );

        return imageResponse;
    }

    @Override
    public List<ImageResponse> toResponses(List<Picture> pictures) {
        if ( pictures == null ) {
            return null;
        }

        List<ImageResponse> list = new ArrayList<ImageResponse>( pictures.size() );
        for ( Picture picture : pictures ) {
            list.add( toResponse( picture ) );
        }

        return list;
    }
}

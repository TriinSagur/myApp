package ee.bcs.myApp.bank.domain.picture;

import ee.bcs.myApp.bank.service.image.ImageRequest;
import ee.bcs.myApp.bank.service.image.ImageResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class PictureService {

    @Resource
    private PictureRepository pictureRepository;

    @Resource
    private PictureMapper pictureMapper;

    public void addPicture(ImageRequest request) {
        byte[] data = request.getData().getBytes(StandardCharsets.UTF_8);
        Picture picture = new Picture();
        picture.setData(data);
        pictureRepository.save(picture);
    }

    public List<ImageResponse> getAllPictures() {
        List<Picture> pictures = pictureRepository.findAll();

//        Enda loodud mäpper
//        List<ImageResponse> result = new ArrayList<>();
//        for (Picture picture : pictures) {
//            ImageResponse imageResponse = new ImageResponse();
//            String dataString = new String(picture.getData(), StandardCharsets.UTF_8);
//            imageResponse.setData(dataString);
//            result.add(imageResponse);
//        }
        return pictureMapper.toResponses(pictures);
    }
}

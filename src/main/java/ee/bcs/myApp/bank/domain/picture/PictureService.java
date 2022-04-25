package ee.bcs.myApp.bank.domain.picture;

import ee.bcs.myApp.bank.service.image.ImageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@Service
public class PictureService {

    @Resource
    private PictureRepository pictureRepository;

    public void addPicture(ImageRequest request) {
        byte[] data = request.getData().getBytes(StandardCharsets.UTF_8);
        Picture picture = new Picture();
        picture.setData(data);
        pictureRepository.save(picture);
    }
}

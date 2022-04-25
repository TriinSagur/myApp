package ee.bcs.myApp.bank.domain.Picture;

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
}


package ee.bcs.myApp.bank.domain.picture;


import ee.bcs.myApp.bank.service.image.ImageRequest;
import ee.bcs.myApp.bank.service.image.ImageResponse;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.color.ICC_Profile;
import java.nio.charset.StandardCharsets;
import java.util.List;

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

    public List <ImageResponse > getALlPictures() {
        List <Picture> pictures = pictureRepository.findAll();

        new String(picture.getData() )
        List ImageResponse result = new ArrayList<>()
    }
}

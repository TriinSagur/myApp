package ee.bcs.myApp.bank.service.image;


import ee.bcs.myApp.bank.domain.picture.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ImageService {

    @Resource
    private PictureService pictureService;

    public void addPicture(ImageRequest request) {
        pictureService.addPicture(request);



    }

    public List<ImageResponse> getAllPictures() {
        return pictureService.getAllPictures();
    }
}

package ee.bcs.myApp.bank.service.image;

import ee.bcs.myApp.bank.domain.picture.PictureService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Resource
    private ImageService imageService;

    private PictureService pictureService;

    @PostMapping("/in")
    public void addPicture(@RequestBody ImageRequest request) {
        imageService.addPicture(request);
    }

    @GetMapping("/all")
    public List<ImageResponse> getAllPictures() {
        return pictureService.getAllPictures();

    }
}

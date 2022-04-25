package ee.bcs.myApp.bank.service.image;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/picture")
public class ImageController {

    @Resource
    private ImageService imageService;

    @PostMapping("/in")
    public void addPicture(@RequestBody ImageRequest request) {
        imageService.addPicture(request);

    }
@GetMapping("/all")
    public ImageResponse getAllPictures() {
    return imageService.getAllPictures();
    }

}

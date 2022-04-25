package ee.bcs.myApp.bank.service.image;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping


public class ImageController {

    @Resource
    private ImageService pictureService;

    @PostMapping("/id")
    public void addPicture(@RequestBody ImageRequest request) {
        pictureService.addPicture(request);

    }
}

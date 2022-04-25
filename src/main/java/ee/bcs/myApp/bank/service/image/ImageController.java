package ee.bcs.myApp.bank.service.image;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/picture")
public class ImageController {

    @Resource
    private ImageService imageService;

    @PostMapping("/new")
    @Operation(summary = "lisab uue pildi")
    public void addPicture(@RequestBody ImageRequest request) {
        imageService.addPicture(request);
    }

}

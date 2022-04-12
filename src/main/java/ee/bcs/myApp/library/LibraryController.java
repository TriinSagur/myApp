package ee.bcs.myApp.library;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Resource
    private LibraryService libraryService;





}

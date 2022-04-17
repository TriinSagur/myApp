package ee.bcs.myApp.library.service;

import ee.bcs.myApp.library.bookauthor.BookAuthorResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Resource
    private LibraryService libraryService;

    @GetMapping("/all")
    @Operation (summary = "Tagastab kõik raamatud autoritega.")
    public List <BookAuthorResponse> getAllBookAuthors() {
        return libraryService.getAllBookAuthors();
    }


}

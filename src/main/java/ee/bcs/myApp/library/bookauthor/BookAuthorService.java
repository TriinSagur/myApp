package ee.bcs.myApp.library.bookauthor;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookAuthorService {

    @Resource
    private BookAuthorMapper bookAuthorMapper;

    @Resource
    private BookAuthorRepository bookAuthorRepository;


}

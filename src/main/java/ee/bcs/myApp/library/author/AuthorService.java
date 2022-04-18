package ee.bcs.myApp.library.author;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class  AuthorService {

    @Resource
    private AuthorMapper authorMapper;

    @Resource
    AuthorRepository authorRepository;

    public AuthorDto addNewAuthor(AuthorDto authorDto) {
        Author author = authorMapper.toEntity(authorDto);
        authorRepository.save(author);

        return authorMapper.toDto(author);
    }

}

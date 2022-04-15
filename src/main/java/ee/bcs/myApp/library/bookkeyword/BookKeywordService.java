package ee.bcs.myApp.library.bookkeyword;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookRepository;
import ee.bcs.myApp.library.book.BookService;
import ee.bcs.myApp.library.bookkeyword.BookKeyword;
import ee.bcs.myApp.library.bookkeyword.BookKeywordDto;
import ee.bcs.myApp.library.keyword.Keyword;
import ee.bcs.myApp.library.keyword.KeywordRepository;
import ee.bcs.myApp.library.keyword.KeywordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookKeywordService {

    @Resource
    private BookKeywordRepository bookKeywordRepository;
    @Resource
    private BookRepository bookRepository;
    @Resource
    private KeywordRepository keywordRepository;
    @Resource
    private BookKeywordMapper bookKeywordMapper;


    public void addNewBookKeyword(String title, String keyword) {
        BookKeyword bookKeyword = new BookKeyword();
        Book book = bookRepository.findByTitle(title);
        Keyword byKeyword = keywordRepository.findByKeyword(keyword);
        bookKeyword.setBook(book);
        bookKeyword.setKeyword(byKeyword);
        bookKeywordRepository.save(bookKeyword);
    }
    public List<BookKeywordDto> getAllBookKeywords() {
        List<BookKeyword> bookKeywords = bookKeywordRepository.findAll();
        return bookKeywordMapper.toDtos(bookKeywords);
    }

    public BookKeywordDto findBookKeywordById(Integer id) {
        BookKeyword bookKeyword = bookKeywordRepository.getById(id);
        return bookKeywordMapper.toDto(bookKeyword);
    }

    public void removeBookKeywordById(Integer id) {
        bookKeywordRepository.deleteById(id);
    }

    public void updateBookKeyword(Integer id, String title, String keyword) {
        BookKeyword bookKeyword = bookKeywordRepository.getById(id);
        Book book = bookRepository.findByTitle(title);
        Keyword byKeyword = keywordRepository.findByKeyword(keyword);
        bookKeyword.setBook(book);
        bookKeyword.setKeyword(byKeyword);
        bookKeywordRepository.save(bookKeyword);
    }

    public List<BookKeywordDto> getAllKeywordsByTitle(String title) {
        List<BookKeyword> bookKeywords = bookKeywordRepository.findByTitle(title);
        return bookKeywordMapper.toDtos(bookKeywords);
    }

    public List<BookKeywordDto> getAllBooksByKeyword(String keyword) {
        List<BookKeyword> byKeyword = bookKeywordRepository.findByKeyword(keyword);
        return bookKeywordMapper.toDtos(byKeyword);
    }
}

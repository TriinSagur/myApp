package ee.bcs.myApp.library.bookkeyword;


import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookRepository;
import ee.bcs.myApp.library.keyword.Keyword;
import ee.bcs.myApp.library.keyword.KeywordRepository;

import javax.annotation.Resource;

public class BookKeywordService {

    @Resource
    private BookKeywordMapper bookKeywordMapper;

    @Resource
    private BookKeywordRepository bookKeywordRepository;

    @Resource
    private KeywordRepository keywordRepository;

    @Resource
    private BookRepository bookRepository;

    public BookKeywordDto addNewBookKeywordConnection(Integer bookId, Integer keywordId) {
        Keyword keyword = keywordRepository.getById(keywordId);
        Book book = bookRepository.getById(bookId);
        BookKeyword bookKeyword = new BookKeyword();
        bookKeyword.setBook(book);
        bookKeyword.setKeyword(keyword);
        bookKeywordRepository.save(bookKeyword);
        return bookKeywordMapper.toDto(bookKeyword);
    }

}

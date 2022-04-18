package ee.bcs.myApp.library.book;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


@Service
public class BookService {


    @Resource
    private BookRepository bookRepository;

    @Resource
    private BookMapper bookMapper;


    public NewBookRequest addNewBook(NewBookRequest newBookRequest) {

        Book book = bookMapper.toEntity(newBookRequest);

        bookRepository.save(book);

        return bookMapper.toDto(book);


    }


    public NewBookRequest findBookById(Integer id) {

        Optional<Book> book = bookRepository.findById(id);
        Book book1 = new Book();

        if (book.isPresent()) {
            book1 = book.get();
        }
        else {
//TODO: kuidas saada veasonumi???
            book1 = null;

        }

        return bookMapper.toDto(book1);

//        Book book = bookRepository.getById(id);
//
//        return bookMapper.toDto(book);

    }

    public List<NewBookRequest> findAllBooks() {

        List<Book> books = bookRepository.findAll();

        return bookMapper.toDtos(books);

    }


    public void updateBookById(Integer id, NewBookRequest newBookRequest) {



        Book book = bookRepository.getById(id);
        bookMapper.updateBookFromBookDto(newBookRequest, book);
        bookRepository.save(book);

    }

    public String removeBookById(Integer id) {

        Optional<Book> book  = bookRepository.findById(id);
        String response = null;
        if (book.isPresent()) {
            bookRepository.deleteById(id);
            response = "Book is removed";
        } else {
            response = "Book is not found";
        }
        return response;

//        bookRepository.deleteById(id);

    }

    public String removeBookByTitle(String title) {
        List<Book> books = bookRepository.findAll();

        String response = null;
        for (Book book : books) {
            if (book.getTitle().equals(title)){
                bookRepository.delete(book);
                response = title + " book is removed.";
            }
             else {
                response = title + " book is not found";
            }
        }
      return response;
    }
}

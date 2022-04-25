package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Integer> {


}
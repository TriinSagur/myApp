package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookauthorRepository extends JpaRepository<Book, Integer> {
}
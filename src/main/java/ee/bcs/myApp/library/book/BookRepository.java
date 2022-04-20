package ee.bcs.myApp.library.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("select b from Book b where upper(b.title) = upper(?1)")
    Book findByTitle(String title);



}
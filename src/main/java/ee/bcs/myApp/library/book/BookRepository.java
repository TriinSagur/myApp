package ee.bcs.myApp.library.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {




    @Query("select b from Book b where upper(b.title) = upper(?1)")
    Book findByTitle(String title);

    @Query("select b from Book b where b.year = ?1")
    Book findByYear(Integer year);

    @Query("select b from Book b where b.year = ?1")
    static List<Book> findsByYear(Integer year) {
        return null;
    }


}
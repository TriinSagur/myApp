package ee.bcs.myApp.library.bookauthor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Integer> {
    @Query("select b from BookAuthor b where upper(b.author.lastName) = upper(?1)")
    List<BookAuthor> findByAuthor(String lastName);

    @Query("select b from BookAuthor b " +
            "where upper(b.book.title) like upper(concat('%', ?1, '%')) or upper(b.author.firstName) like upper(concat('%', ?2, '%')) or upper(b.author.lastName) like upper(concat('%', ?3, '%')) " +
            "order by b.book.title")
    List<BookAuthor> findByWord(String title, String firstName, String lastName);

}
package ee.bcs.myApp.library.bookauthor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Integer> {
    @Query("select b from BookAuthor b where upper(b.author.lastName) = upper(?1)")
    List<BookAuthor> findByAuthorLastName(String lastName);


}
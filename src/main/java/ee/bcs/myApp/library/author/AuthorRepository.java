package ee.bcs.myApp.library.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Query("select a from Author a where upper(a.lastName) = upper(?1)")
    Author getByLastName(String lastName);




}
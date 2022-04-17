package ee.bcs.myApp.library.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Query("select a from Author a where upper(a.lastName) = upper(?1) order by a.id")
    Author findAuthorByLastName(String lastName);

    @Transactional
    @Modifying
    @Query("delete from Author a where upper(a.lastName) = upper(?1)")
    void deleteAuthorByLastName(String lastName);




}
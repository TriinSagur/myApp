package ee.bcs.myApp.library.bookkeyword;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookKeywordRepository extends JpaRepository<BookKeyword, Integer> {
    @Query("select b from BookKeyword b where upper(b.book.title) = upper(?1)")
    List<BookKeyword> findByTitle(String title);


    @Query("select b from BookKeyword b where upper(b.keyword.name) = upper(?1)")
    List<BookKeyword> findByKeyword(String name);
}
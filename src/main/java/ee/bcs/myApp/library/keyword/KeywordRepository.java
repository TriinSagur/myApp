package ee.bcs.myApp.library.keyword;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KeywordRepository extends JpaRepository<Keyword, Integer> {
    @Query("select k from Keyword k where upper(k.name) = upper(?1)")
    Keyword findByKeyword(String name);

}
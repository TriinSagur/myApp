package ee.bcs.myApp.library.bookAuthor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Integer> {
}
package ee.bcs.myApp.library.bookkeyword;

import ee.bcs.myApp.library.book.Book;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "book_out", schema = "library")
public class BookOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "is_returned", nullable = false)
    private Boolean isReturned = false;

}
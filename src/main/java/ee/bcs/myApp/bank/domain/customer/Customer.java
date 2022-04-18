package ee.bcs.myApp.bank.domain.customer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
// kogu selle klassi saab genereerida JPA Buddyga. Aga ma lisan siiski siia ka kommentaarid.

// koodi kompileerimise hetkel lisatakse juurde getter ja setter meetodid
@Getter
@Setter
// JPA  - Java Persistence API
// Defineerime ära, et see on tabeli olem
@Entity
// Entity - andmebaasi mõistes tabeli seadistused... Tabeli nimi ja schema
@Table(name = "customer", schema = "bank")
public class Customer {

    // defineerime JPA jaoks ära, et selle muutuda on meil primaar võte
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // defineerime ära veeru nime ja et selle väärtus ei tohi olla tühi
    @Column(name = "id", nullable = false)
    private Integer id;

    // defineerime ära veeru nime ja et selle väärtus ei tohi olla tühi ning max pikkus on 50
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    // defineerime ära veeru nime ja et selle väärtus ei tohi olla tühi ning max pikkus on 50
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    // defineerime ära veeru nime ja et selle väärtus ei tohi olla tühi ning max pikkus on 11
    @Column(name = "isikukood", nullable = false, length = 11)
    private String isikukood;

}
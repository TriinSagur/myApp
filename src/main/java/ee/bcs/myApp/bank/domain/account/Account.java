package ee.bcs.myApp.bank.domain.account;

import ee.bcs.myApp.bank.domain.customer.Customer;
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
@Table(name = "account", schema = "bank")
public class Account {

    // defineerime JPA jaoks ära, et selle muutuda on meil primaar võte
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // defineermie ära veeru nime
    @Column(name = "id", nullable = false)
    private Integer id;

    // defineerime ära entity suhte tüübi (üks-mitmele, mitu-ühele, mitu-mitmele, jne)
    // mõne teise entity'ga (andmebaasi mõistes suhe tabelite vahel)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // defineerime ära veeru nime ja et selle väärtus ei tohi olla tühi ning max pikkus on 5
    @Column(name = "account_number", nullable = false, length = 5)
    private String accountNumber;

    // defineerime ära veeru nime ja et selle väärtus ei tohi olla tühi ning max pikkus on 50
    @Column(name = "balance", nullable = false)
    private Integer balance;

    // defineerime ära veeru nime ja et selle väärtus ei tohi olla tühi
    @Column(name = "locked", nullable = false)
    private Boolean locked = false;

}
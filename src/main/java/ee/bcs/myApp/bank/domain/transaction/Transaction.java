package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.domain.account.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

// kogu selle klassi saab genereerida JPA Buddyga. Aga ma lisan siiski siia ka kommentaarid.

// koodi kompileerimise hetkel lisatakse juurde getter ja setter meetodid
@Getter
@Setter
// JPA  - Java Persistence API
// Defineerime ära, et see on tabeli olem
@Entity
// Entity - andmebaasi mõistes tabeli seadistused... Tabeli nimi ja schema
@Table(name = "transaction", schema = "bank")
public class Transaction {

    // defineerime JPA jaoks ära, et selle muutuda on meil primaar võte
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // defineerime ära veeru nime ja et selle väärtus ei tohi olla tühi
    @Column(name = "id", nullable = false)
    private Integer id;

    // defineerime ära veeru nime ja max pikkus on 11
    @Column(name = "sender_account_number", length = 11)
    private String senderAccountNumber;

    // defineerime ära veeru nime ja max pikkus on 11
    @Column(name = "receiver_account_number", length = 11)
    private String receiverAccountNumber;

    // defineerime ära veeru nime ja et selle väärtus ei tohi olla tühi
    @Column(name = "amount", nullable = false)
    private Integer amount;

    // defineerime ära veeru nime ja et selle väärtus ei tohi olla tühi
    @Column(name = "balance", nullable = false)
    private Integer balance;

    // defineerime ära veeru nime ja et selle väärtus ei tohi olla tühi ning max pikkus on 1
    @Column(name = "type", nullable = false, length = 1)
    private String type;

    // defineerime ära veeru nime ja et selle väärtus ei tohi olla tühi
    @Column(name = "transaction_date_time", nullable = false)
    private Instant transactionDateTime;

    // defineerime ära entity suhte tüübi (üks-mitmele, mitu-ühele, mitu-mitmele, jne)
    // mõne teise entity'ga (andmebaasi mõistes suhe tabelite vahel)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

}
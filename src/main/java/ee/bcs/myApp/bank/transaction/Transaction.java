package ee.bcs.myApp.bank.transaction;

import ee.bcs.myApp.bank.account.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "sender_account_number", length = 11)
    private String senderAccountNumber;

    @Column(name = "receiver_account_number", length = 11)
    private String receiverAccountNumber;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "balance", nullable = false)
    private Integer balance;

    @Column(name = "type", nullable = false, length = 1)
    private String type;

    @Column(name = "transaction_date_time", nullable = false)
    private Instant transactionDateTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

}
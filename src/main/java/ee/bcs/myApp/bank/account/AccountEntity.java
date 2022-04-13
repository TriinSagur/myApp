package ee.bcs.myApp.bank.account;

import ee.bcs.myApp.bank.customer.CustomerEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "account_entity")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @Column(name = "account_number", nullable = false, length = 5)
    private String accountNumber;

    @Column(name = "balance", nullable = false)
    private Integer balance;

    @Column(name = "locked", nullable = false)
    private Boolean locked = false;

}
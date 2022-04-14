package ee.bcs.myApp.bank.domain.account;

import ee.bcs.myApp.bank.domain.customer.Customer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "account_number", nullable = false, length = 5)
    private String accountNumber;

    @Column(name = "balance", nullable = false)
    private Integer balance;

    @Column(name = "locked", nullable = false)
    private Boolean locked = false;

    @Data

    public static class AccountDto {

        private Integer id;

        @NotNull
        private Integer customerId;

        @NotNull
        @Size(min = 5, max = 5)
        private String accountNumber;


        private Integer balance = 0;
        private Boolean locked = false;

    }
}
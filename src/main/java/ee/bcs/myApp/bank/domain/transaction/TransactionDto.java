package ee.bcs.myApp.bank.domain.transaction;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class TransactionDto implements Serializable {
    private Integer id;
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private Integer amount;
    private Integer balance;
    private String type;
    private Instant transactionDateTime;
    private Integer accountId;
    private Integer accountCustomerId;
    private String accountCustomerFirstName;
    private String accountCustomerLastName;
    private String accountCustomerIsikukood;
    private String accountAccountNumber;
    private Integer accountBalance;
    private Boolean accountLocked;
}

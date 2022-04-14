package ee.bcs.myApp.bank.domain.transaction;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class TransactionDto implements Serializable {
    private final Integer id;
    private final String senderAccountNumber;
    private final String receiverAccountNumber;
    private final Integer amount;
    private final Integer balance;
    private final String type;
    private final Instant transactionDateTime;
    private final Integer accountId;
    private final Integer accountCustomerId;
    private final String accountCustomerFirstName;
    private final String accountCustomerLastName;
    private final String accountCustomerIsikukood;
    private final String accountAccountNumber;
    private final Integer accountBalance;
    private final Boolean accountLocked;
}

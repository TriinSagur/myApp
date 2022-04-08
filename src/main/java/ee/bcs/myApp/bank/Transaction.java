package ee.bcs.myApp.bank;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Transaction {

    private Integer id;
    private Integer accountId;
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private Integer amount;
    private Integer balance;
    private Character type;
    private LocalDateTime transactionDateTime;
}

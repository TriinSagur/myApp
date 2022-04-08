package ee.bcs.myApp.bank;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Transaction {

    private Integer Id;
    private Integer accountId;
    private String senderAccountNumber;
    private String recieverAccountNumber;
    private Integer account;
    private Integer balance;
    private Character type;
    private LocalDateTime transactionDateTime;

}

package ee.bcs.myApp.bank;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Transaction {
    private Integer id;
    private Integer AccountId;
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private Integer amount;
    private Boolean locked;
    private Character type;
    private LocalDateTime transactionDateTime;
}
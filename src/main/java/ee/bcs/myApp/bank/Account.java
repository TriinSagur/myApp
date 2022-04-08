package ee.bcs.myApp.bank;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Account {
    private Integer id;
    private Integer bankAccountId;
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private Integer amount;
    private Integer balance;
    private Character type;
    private LocalDateTime transactionDateTime;
}

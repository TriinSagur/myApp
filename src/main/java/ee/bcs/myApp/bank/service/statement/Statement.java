package ee.bcs.myApp.bank.service.statement;

import lombok.Data;

import java.time.Instant;

@Data
public class Statement {
    private Integer id;
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private Integer amount;
    private Integer balance;
    private Instant transactionDateTime;
}

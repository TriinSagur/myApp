package ee.bcs.myApp.bank.service;

import lombok.Data;

@Data
public class MoneyRequest {
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private Integer amount;

}

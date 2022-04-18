package ee.bcs.myApp.bank.service;

import lombok.Data;

@Data
public class SendMoneyRequest {
private Integer senderAccountId;
private String receiverAccountNumber;
private Integer amount;

}

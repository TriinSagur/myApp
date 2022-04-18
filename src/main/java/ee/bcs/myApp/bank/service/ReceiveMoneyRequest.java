package ee.bcs.myApp.bank.service;

import lombok.Data;

@Data
public class ReceiveMoneyRequest {
    private String senderAccountNumber;
    private String recieverAccountNumber;
    private Integer amount;


}

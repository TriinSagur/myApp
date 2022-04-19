package ee.bcs.myApp.bank.service;

import lombok.Data;

@Data
public class MoneyRequest {
    private String senderaccountNumber;
    private String receiveraccountNumber;
    private Integer amount;


}

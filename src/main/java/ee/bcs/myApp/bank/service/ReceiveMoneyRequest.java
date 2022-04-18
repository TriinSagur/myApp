package ee.bcs.myApp.bank.service;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ReceiveMoneyRequest {
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private Integer amount;

}

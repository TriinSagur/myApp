package ee.bcs.myApp.bank.service;

import lombok.Data;

@Data
public class TransactionResponse {
    private Integer referenceNumber;

    public TransactionResponse() {
    }

    public TransactionResponse(Integer referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
}

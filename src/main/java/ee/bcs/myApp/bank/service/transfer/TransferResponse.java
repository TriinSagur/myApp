package ee.bcs.myApp.bank.service.transfer;

import lombok.Data;

@Data
public class TransferResponse {
    private Integer referenceNumber;

    public TransferResponse() {
    }

    public TransferResponse(Integer referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
}

package ee.bcs.myApp.infrastructure.error;

import lombok.Data;

@Data
public class BankError {
    private String message;
    private Integer errorCode;
}

package ee.bcs.myApp.infrastructure.error;

import lombok.Data;

@Data
public class MyAppError {
    private String message;
    private Integer errorCode;
}

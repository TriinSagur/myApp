package ee.bcs.myApp.bank.account;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Account {
    public static Integer idCounter = 1;

    private Integer id;
    private Integer CustomerId;
    private String AccountNumber;
    private Integer balance;
    private Boolean locked;

    public void updateId() {
        id=idCounter;
        idCounter++;
    }
}

package ee.bcs.myApp.bank.account;

import lombok.Data;

@Data
public class Account {
    public static Integer idCounter = 1;
    private Integer id;
    private Integer customerId;
    private String accountNumber;
    private Integer balance;
    private Boolean locked;

    public void updateId() {
        id = idCounter;
        idCounter++;
    }

}

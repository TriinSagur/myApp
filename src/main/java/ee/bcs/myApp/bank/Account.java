package ee.bcs.myApp.bank;

import lombok.Data;

@Data
public class Account {
    private Integer id;
    private Integer customerId;
    private Integer accountNumber;
    private Integer balance;
    private Boolean locked;

}

package ee.bcs.myApp.bank;


import lombok.Data;

@Data
public class Account {
    private Integer id;
    private Integer customerId;
    private String accountNumber;
    private Integer balance;
    private Boolean locked;

}

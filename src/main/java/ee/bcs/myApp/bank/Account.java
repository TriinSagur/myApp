package ee.bcs.myApp.bank;

import lombok.Data;

@Data
public class Account {

    private Integer id;
    private Integer customerId; //päriselus saab siia panna Integer klassi asemel Customer klassi
    private String accountNumber;
    private Integer balance;
    private Boolean locked;

}

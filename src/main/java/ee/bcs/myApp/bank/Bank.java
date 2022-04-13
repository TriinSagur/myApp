package ee.bcs.myApp.bank;

import ee.bcs.myApp.bank.customer.Customer;
import ee.bcs.myApp.bank.account.Account;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bank {//mängime enda database ja salvestame siia andmeid See on Repository asemel
    private List<Customer> customers = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();


}

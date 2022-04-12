package ee.bcs.myApp.bank;

import ee.bcs.myApp.bank.account.Account;
import ee.bcs.myApp.bank.customer.Customer;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bank {
    private List<Customer> customers = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

}

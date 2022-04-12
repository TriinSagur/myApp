package ee.bcs.myApp.bank.customer;

import ee.bcs.myApp.bank.Customer;
import ee.bcs.myApp.bank.account.Account;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bank {
    private List<Customer> customers = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

}
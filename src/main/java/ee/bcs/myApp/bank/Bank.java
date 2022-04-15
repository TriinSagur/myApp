package ee.bcs.myApp.bank;

import ee.bcs.myApp.bank.domain.account.Account;
import ee.bcs.myApp.bank.domain.customer.Customer;
import ee.bcs.myApp.bank.domain.transaction.Transaction;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bank {
    private List<Customer> customers = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();
}

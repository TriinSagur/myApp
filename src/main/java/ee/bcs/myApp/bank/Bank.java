package ee.bcs.myApp.bank;


import ee.bcs.myApp.bank.customer.Customer;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bank {

    private List<Customer> customers = new ArrayList<>();
    private List<Customer> accounts = new ArrayList<>();
    private List<Customer> transactions = new ArrayList<>();


}

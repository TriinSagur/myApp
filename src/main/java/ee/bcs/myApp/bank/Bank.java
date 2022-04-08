package ee.bcs.myApp.bank;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bank {//mängime enda database ja salvestame siia andmeid See on Repository asemel
    private List<Customer> customers = new ArrayList<>();
    private List<Customer> accounts = new ArrayList<>();
    private List<Customer> transactions = new ArrayList<>();


}

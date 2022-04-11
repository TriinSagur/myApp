package ee.bcs.myApp.bank.account;

import ee.bcs.myApp.MyAppApplication;
import ee.bcs.myApp.bank.Bank;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    public AccountDto addNewAccount(AccountDto accountDto) {
        List<Account> accounts = MyAppApplication.bankRepository.getAccounts();
        Account account = new Account();
        account.set


        return null;
    }
}

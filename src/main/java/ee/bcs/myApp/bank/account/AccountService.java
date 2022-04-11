package ee.bcs.myApp.bank.account;

import ee.bcs.myApp.MyAppApplication;
import ee.bcs.myApp.bank.Bank;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    public AccountDto addNewAccount(AccountDto accountDto) {
        List<Account> accounts = MyAppApplication.bankRepository.getAccounts();
        Account account = toEntity(accountDto);
        account.uodateId;
        accounts.add(account);

        AccountDto accountDto = new AccountDto();
        account.setId(account.getId());
        account.setCustomerId(account.getCustomerId());
        account.setAccountNumber(account.getAccountNumber());
        account.setBalance(account.getBalance());
        account.setLocked(account.getLocked());

        return accountDto;
    }

    private Account toEntity(AccountDto accountDto) {
        Account account = new Account();
        account.setCustomerId(accountDto);
        account.setAccountNumber(accountDto);
        account.setBalance(accountDto.getBalance());
        account.setLocked(false);
        return account;
    }
}

package ee.bcs.myApp.bank.account;

import ee.bcs.myApp.MyAppApplication;
import ee.bcs.myApp.bank.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    public AccountDto addNewAccount(AccountDto accountDto) {
        List<Customer> accounts = MyAppApplication.bankRepository.getAccounts();
        Account account = toEntity(accountDto);
        account.updateId();
        account.add(account);

        accountDto = toDto(account);
        return accountDto;
    }

    private void toDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setCustomerId(account.getCustomerId());
        accountDto.setAccountNumber(accountDto.getAccountNumber());
        accountDto.setBalance(account.getBalance());
        accountDto.setLocked(account.getLocked());
    }

    private void toEntity(AccountDto accountDto) {
        Account account = new Account();
        account.setCustomerId(accountDto.getCustomerId());
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setBalance(accountDto.getBalance());
        account.setLocked(false);
        account.updateId();
    }
}

package ee.bcs.myApp.bank.account;

import ee.bcs.myApp.MyAppApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    public AccountDto addNewAccount(AccountDto accountDto) {
        List<Account> accounts = MyAppApplication.bankRepository.getAccounts();
        Account account = toEntity(accountDto);
        account.updateId();
        accounts.add(account);

        accountDto = toDto(account);
        return accountDto;
    }

    private AccountDto toDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setCustomerId(account.getCustomerId());
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setBalance(account.getBalance());
        accountDto.setLocked(account.getLocked());
        return accountDto;
    }

    private Account toEntity(AccountDto accountDto) {
        Account account = new Account();
        account.setCustomerId(accountDto.getCustomerId());
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setBalance(accountDto.getBalance());
        account.setLocked(false);
        return account;
    }
}

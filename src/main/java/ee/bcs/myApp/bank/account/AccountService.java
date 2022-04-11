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

        return toDto(account);
    }

    private AccountDto toDto(Account account) {
        AccountDto accountDtoResponse = new AccountDto();
        accountDtoResponse.setId(account.getId());
        accountDtoResponse.setCustomerId(account.getCustomerId());
        accountDtoResponse.setAccountNumber(account.getAccountNumber());
        accountDtoResponse.setBalance(account.getBalance());
        accountDtoResponse.setLocked(account.getLocked());
        return accountDtoResponse;
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

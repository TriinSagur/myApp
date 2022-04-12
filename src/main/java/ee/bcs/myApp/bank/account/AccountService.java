package ee.bcs.myApp.bank.account;


import ee.bcs.myApp.MyAppApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<AccountDto> findAllAccounts() {
        List<Account> accounts = MyAppApplication.bankRepository.getAccounts();
        return toDto(accounts);
    }

    public AccountDto findAccountById(Integer id) {
        List<Account> accounts = MyAppApplication.bankRepository.getAccounts();

        Account result = findAccountById(id, accounts);
        return toDto(result);
    }

    public void removeAccountById(Integer id) {
        List<Account> accounts = MyAppApplication.bankRepository.getAccounts();
        Account result = findAccountById(id, accounts);
        accounts.remove(result);

    }

    private Account findAccountById(Integer id, List<Account> accounts) {
        Account result = new Account();
        for (Account account : accounts) {
            if (account.getId().equals(id)) {

                result = account;

            }

        }
        return result;
    }

    public void updateAccountById(Integer id, AccountDto accountDto) {
        List<Account> accounts = MyAppApplication.bankRepository.getAccounts();
        Account account = findAccountById(id, accounts);
        account.setCustomerId(accountDto.getCustomerId());
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setLocked(accountDto.getLocked());
        account.setBalance(accountDto.getBalance());

    }

    private AccountDto toDto(Account account) {
        AccountDto accountDto1 = new AccountDto();
        accountDto1.setId(account.getId());
        accountDto1.setAccountNumber(account.getAccountNumber());
        accountDto1.setCustomerId(account.getCustomerId());
        accountDto1.setBalance(account.getBalance());
        accountDto1.setLocked(account.getLocked());
        return accountDto1;
    }

    private List<AccountDto> toDto(List<Account> accounts) {
        List<AccountDto> accountDtos = new ArrayList<>();

        for (Account account : accounts) {
            AccountDto accountDto = toDto(account);
            accountDtos.add(accountDto);
        }
        return accountDtos;
    }

    private Account toEntity(AccountDto accountDto) {
        Account account = new Account();
        account.setCustomerId(accountDto.getId());
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setBalance(accountDto.getBalance());
        account.setLocked(false);
        return account;
    }

}

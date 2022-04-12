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

        accountDto = toDto(account);

        return accountDto;
    }

    public List<AccountDto> findAllAccounts() {
        List<Account> accounts = MyAppApplication.bankRepository.getAccounts();
        return EntityToAccountDtoList(accounts);
    }

    public AccountDto findAccountById(Integer id) {
        List<Account> accounts = MyAppApplication.bankRepository.getAccounts();
        Account foundAccount = findAccount(accounts, id);
        return toDto(foundAccount);
    }


    public void removeAccountById(Integer id) {
        List<Account> accounts = MyAppApplication.bankRepository.getAccounts();
        Account foundAccount = findAccount(accounts, id);
        accounts.remove(foundAccount);
    }


    private List<AccountDto> EntityToAccountDtoList(List<Account> accounts) {
        List<AccountDto> accountDtos = new ArrayList<>();
        for (Account account : accounts) {
            accountDtos.add(toDto(account));
        }
        return accountDtos;
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
        account.setId(accountDto.getId());
        account.setCustomerId(accountDto.getCustomerId());
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setBalance(accountDto.getBalance());
        account.setLocked(false);
        return account;
    }

    private Account findAccount(List<Account> accounts, Integer id) {
        Account foundAccount = new Account();
        for (Account account : accounts) {
            if (account.getId().equals(id)) {
                foundAccount = account;
            }
        }
        return foundAccount;
    }

    public void updateAccountById(Integer id, AccountDto accountDto) {
        List<Account> accounts = MyAppApplication.bankRepository.getAccounts();
        Account account = findAccount(accounts, id);
        accountToAccountDtoMapping(accountDto, account);
    }

    private void accountToAccountDtoMapping(AccountDto accountDto, Account account) {
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setCustomerId(accountDto.getCustomerId());
        account.setBalance(accountDto.getBalance());
        account.setLocked(accountDto.getLocked());
    }
}

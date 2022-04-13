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
        return toDto(accounts);
    }

    public AccountDto findAccountById(Integer id) {
        List<Account> accounts = MyAppApplication.bankRepository.getAccounts();
        Account result = findAccountByIdAccount(id, accounts);
        AccountDto accountDto = toDto(result);
        return toDto(result);
    }

    private Account findAccountByIdAccount(Integer id, List<Account> accounts) {
        Account result = new Account();
        for (Account account : accounts) {
            if (account.getId().equals(id)) {
                result = account;
            }

        }
        return result;
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
        account.setId(accountDto.getId());
        account.setCustomerId(accountDto.getCustomerId());
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setBalance(accountDto.getBalance());
        account.setLocked(false);
        return account;
    }


    public void deleteAccountById(Integer id) {
        List<Account> accounts = MyAppApplication.bankRepository.getAccounts(); //Me lõime listi, kuhu panime kõik accoundid, mis olemas
        Account accountFound = findAccountByIdAccount(id, accounts); // Tegime muutuja ja lisasime sinna meetodi tulemuse, kuna meetod findAccountByIdAccount oli olemas siis saime lühemalt. Katsu sellest ka aru saada.
        accounts.remove(accountFound); //kustutasime nimekrijast leitud accoundi
    }
}

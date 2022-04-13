package ee.bcs.myApp.bank.account;

import ee.bcs.myApp.MyAppApplication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;


@Service
public class AccountService {

    @Resource
    private AccountRepository accountRepository;

    @Resource
    private AccountMapper accountMapper;

    public AccountDto addNewAccount(AccountDto accountDto) {
        return accountDto;
    }

    public AccountResponse findAccountInfoById(Integer id) {
        Account account = accountRepository.getById(id);
        return
                accountResponse accountResponse = accountMapper;

//        public List<AccountDto> findAllAccounts() {
//            List<Account> accounts = accountRepository.findAll();
//            return accountMapper.findAccountInfoById(id);
//
//        };
//
//    }

//        List<Account> accounts = MyAppApplication.bankRepository.getAccounts();
//        Account account = toEntity(accountDto);
//        account.updateId();
//        accounts.add(account);
//
//        accountDto = toDto(account);
//        return accountDto;
//    }
//
//    public List<AccountDto> findAllAccounts() {
//        List<Account> accounts = MyAppApplication.bankRepository.getAccounts();
//        return toDto(accounts);
//    }
//
//
//    public AccountDto findAccountId(Integer id) {
//        List<Account> accounts = MyAppApplication.bankRepository.getAccounts();
//        Account account = findAccountById(id, accounts);
//        return toDto(account);
//    }
//
//    public void removeAccountsByID(Integer id) {
//        List<Account> accounts = MyAppApplication.bankRepository.getAccounts();
//        Account account = findAccountById(id, accounts);
//        accounts.remove(account);
//    }
//
//    public void updateAccountById(Integer id, AccountDto accountDto) {
//        List<Account> accounts = MyAppApplication.bankRepository.getAccounts();
//        Account account = findAccountById(id, accounts);
//        account.setCustomerId(accountDto.getCustomerId());
//        account.setAccountNumber(accountDto.getAccountNumber());
//        account.setBalance(accountDto.getBalance());
//        account.setLocked(accountDto.getLocked());
//
//    }
//
//    private Account findAccountById(Integer id, List<Account> accounts) {
//        Account result = new Account();
//        for (Account account : accounts) {
//            if (account.getId().equals(id)) {
//                result = account;
//            }
//            return result;
//        }
//    }
//
//
//    private AccountDto toDto(Account account) {
//        AccountDto accountDto = new AccountDto();
//        accountDto.setId(account.getId());
//        accountDto.setCustomerId(account.getCustomerId());
//        accountDto.setAccountNumber(account.getAccountNumber());
//        accountDto.setBalance(account.getBalance());
//        accountDto.setLocked(account.getLocked());
//        return accountDto;
//    }
//
//
//    private List<AccountDto> toDto(List<Account> accounts) {
//        List<AccountDto> accountDtos = new ArrayList<>();
//        for (Account account : accounts) {
//            AccountDto accountDto = toDto(account);
//            accountDtos.add(accountDto);
//        }
//        return accountDtos;
//    }
//
//
//    private Account toEntity(AccountDto accountDto) {
//        Account account = new Account();
//        account.setCustomerId(accountDto.getCustomerId());
//        account.setAccountNumber(accountDto.getAccountNumber());
//        account.setBalance(accountDto.getBalance());
//        account.setLocked(false);
//        return account;
//    }
//}
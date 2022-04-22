package ee.bcs.myApp.bank.domain.account;

import ee.bcs.myApp.bank.domain.customer.Customer;
import ee.bcs.myApp.bank.domain.customer.CustomerRepository;
import ee.bcs.myApp.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Resource
    private AccountRepository accountRepository;

    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private ValidationService validationService;

    public AccountDto addNewAccount(AccountDto accountDto) {

        return accountDto;
    }

    public List<AccountResponse> findAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accountMapper.toResponses(accounts);
    }


    public AccountResponse findAccountInfoById(Integer id) {
        Account account = accountRepository.getById(id);
        AccountResponse accountResponse = accountMapper.toResponse(account);
        return accountMapper.toResponse(account);
    }

    public void removeAccountById(Integer id) {
        accountRepository.deleteById(id);
    }

    public void updateAccountById(Integer id, AccountDto accountDto) {
        Account account = accountRepository.getById(id);
        accountMapper.updateEntity(accountDto, account);
        Customer customer = customerRepository.getById(accountDto.getCustomerId());
        account.setCustomer(customer);
    }

    public List<AccountResponse> findAccountsInfoByLastName(String lastName) {
        List<Account> accounts = accountRepository.findByLastName(lastName);
        return accountMapper.toResponses(accounts);
    }

    public Account getValidAccountById(Integer accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        validationService.accountExists(accountId, account);
        return account.get();
    }

    public void updateCreditPaymentBalance(Account account, Integer amount) {
        Integer currentBalance = account.getBalance();
        Integer newBalance = currentBalance + amount;
        account.setBalance(newBalance);
        accountRepository.save(account);

    }

    public void updateDebitPaymentBalance(Account account, Integer amount) {
        Integer currentBalance = account.getBalance();
        Integer newBalance = currentBalance - amount;
        account.setBalance(newBalance);
        accountRepository.save(account);
    }

    public Account getValidAccountByAccountNumber(String accountNumber) {
        Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);
        validationService.accountExists(accountNumber, account);
        return account.get();
    }

    public boolean accountExistsByAccountNumber(String accountNumber) {
        return accountRepository.existsByAccountNumber(accountNumber);

    }

    public List<AccountResponse> findAccountsInfoByCustomerId(Integer id) {
        List<Account> accounts = accountRepository.findByCustomerId(id);
        return accountMapper.toResponses(accounts);
    }
//
//    private Account findAccountById(Integer id, List<Account> accounts) {
//        Account result = new Account();
//        for (Account account : accounts) {
//            if (account.getId().equals(id)) {
//                result = account;
//            }
//
//        }
//        return result;
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
//    private List<AccountDto> toDto(List<Account> accounts) {
//        List<AccountDto> accountDtos = new ArrayList<>();
//        for (Account account : accounts) {
//            AccountDto accountDto = toDto(account);
//            accountDtos.add(accountDto);
//        }
//        return accountDtos;
//    }
//
//    private Account toEntity(AccountDto accountDto) {
//        Account account = new Account();
//        account.setCustomerId(accountDto.getCustomerId());
//        account.setAccountNumber(accountDto.getAccountNumber());
//        account.setBalance(accountDto.getBalance());
//        account.setLocked(false);
//        return account;
//    }


}

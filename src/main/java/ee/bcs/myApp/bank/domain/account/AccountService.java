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
    private CustomerRepository customerRepository;

    @Resource
    private AccountRepository accountRepository;

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

    public AccountResponse findAccountInfo(Integer id) {
        Account account = accountRepository.getById(id);
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

    public List<AccountResponse> findAccountInfoByLastName(String lastName) {
        List<Account> accounts = accountRepository.findByLastName(lastName);
        return accountMapper.toResponses(accounts);
    }

    public Account getValidAccountById(Integer accountId) {   // get eeldab, et asi on olemas, kui ei ole, tagastab null
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
}

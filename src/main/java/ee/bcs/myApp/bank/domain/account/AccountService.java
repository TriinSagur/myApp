package ee.bcs.myApp.bank.domain.account;

import ee.bcs.myApp.bank.domain.customer.Customer;
import ee.bcs.myApp.bank.domain.customer.CustomerRepository;
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

    public Account findAccountById(Integer accountId) {
        return accountRepository.getById(accountId);
    }

    public void updateCreditPaymentBalance(Integer accountId, Integer amount) {
        Account account = accountRepository.getById(accountId);
        Integer currentBalance = account.getBalance();
        Integer newBalance = currentBalance + amount;
        account.setBalance(newBalance);
        accountRepository.save(account);
    }

    public void updateDebitPaymentBalance(Integer accountId, Integer amount) {
        Account account = accountRepository.getById(accountId);
        Integer currentBalance = account.getBalance();
        Integer newBalance = currentBalance - amount;
        account.setBalance(newBalance);
        accountRepository.save(account);
    }
}

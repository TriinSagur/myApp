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
    private AccountRepository accountRepository;

    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private AccountMapper accountMapper;

    public Account.AccountDto addNewAccount(Account.AccountDto accountDto) {
        return accountDto;
    }

    public List<AccountResponse> findAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accountMapper.toResponse(accounts);
    }


    public AccountResponse findAccountInfoById(Integer id) {
        Account account = accountRepository.getById(id);
        AccountResponse accountResponse = accountMapper.toResponse(account);
        return accountMapper.toResponse(account);
    }

    public void removeAccountById(Integer id) {
        accountRepository.deleteById(id);
    }

        public void updateAccountById (Integer id, Account.AccountDto accountDto) {
            Account account = accountRepository.getById(id);
            accountMapper.updateEntity(accountDto, account);
            Customer customer = customerRepository.getById(accountDto.getCustomerID());
            account.setCustomer(customer);
        }

        public List<AccountResponse> findAccountsInfoByLastName(String lastName) {
            List<Account> accounts = accountRepository.findByLastName(lastName);
            return accountMapper.toResponse(accounts);
    }

    public Account findAccountById(Integer accountId) {
            return accountRepository.getById(accountId);
        }
    }

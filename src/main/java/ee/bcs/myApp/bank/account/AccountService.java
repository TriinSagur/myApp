package ee.bcs.myApp.bank.account;

import ee.bcs.myApp.bank.customer.Customer;
import ee.bcs.myApp.bank.customer.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class AccountService {

    @Resource
    private AccountRepository accountRepository;

    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private AccountMapper accountMapper;

    public AccountDto addNewAccount(AccountDto accountDto) {

        return null;
    }


    public List<AccountResponse> findAllAccounts() {
        List<Account> accounts = accountRepository.findAll();

        return accountMapper.toResponses(accounts);

    }
    public AccountResponse findAccountInfoById(Integer id) {

        Account account = accountRepository.getById(id);

        return accountMapper.toResponse(account);

    }

    public void removeAccountById(Integer id) {

        accountRepository.deleteById(id);

    }

    public void updateAccountById(Integer id, AccountDto accountDto) {

        Account account = accountRepository.getById(id);

        accountMapper.updateEntity(accountDto,account);
        Customer customer = customerRepository.getById(accountDto.getCustomerId());

        account.setCustomer(customer);
    }

}

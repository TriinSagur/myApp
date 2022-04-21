package ee.bcs.myApp.bank.domain.account;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping
    @Operation(summary = "Lisab uue konto")
    public AccountDto addNewAccount(@Valid @RequestBody AccountDto accountDto) {
        return accountService.addNewAccount(accountDto);
    }

    @GetMapping("/all")
    public List<AccountResponse> findAllAccounts() {
        return accountService.findAllAccounts();
    }

    @GetMapping("/id")
    @Operation(summary = "Otsib konto info ID järgi")
    public AccountResponse findAccountInfoById(@RequestParam Integer id) {
        return accountService.findAccountInfoById(id);
    }

    @GetMapping("/customer-id")
    @Operation(summary = "Otsib konto info kliendi ID järgi")
    public List<AccountResponse> findAccountsInfoByCustomerId(@RequestParam Integer id) {
        return accountService.findAccountsInfoByCustomerId(id);
    }

    @DeleteMapping("/id")
    public void removeAccountById(@RequestParam Integer id) {
        accountService.removeAccountById(id);
    }

    @PutMapping("/id")
    public void updateAccountById(@RequestParam Integer id, @RequestBody AccountDto accountDto) {
        accountService.updateAccountById(id, accountDto);
    }

    @GetMapping("/last-name")
    public List<AccountResponse> findAccountsInfoByLastName(@RequestParam String lastName) {
        return accountService.findAccountsInfoByLastName(lastName);
    }

}

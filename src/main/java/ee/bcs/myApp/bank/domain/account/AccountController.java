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

    @PostMapping("/new")
    @Operation(summary = "lisab uue konto")
    public AccountDto addNewAccount(@Valid @RequestBody AccountDto accountDto) {
        return accountService.addNewAccount(accountDto);
    }

    @GetMapping("/all")
    @Operation(summary = "naitab koik kontod")
    public List<AccountResponse> findAllAccounts() {
        return accountService.findAllAccounts();
    }

    @GetMapping("/id")
    @Operation(summary = "otsib konto ID jargi")
    public AccountResponse findAccountInfoById(@RequestParam Integer id) {
        return accountService.findAccountInfoById(id);
    }
    @GetMapping("/customer-id")
    @Operation(summary = "otsib konto customer ID jargi")
    public List<AccountResponse> findAccountsInfoByCustomerId (@RequestParam Integer id) {
        return accountService.findAccountsInfoByCustomerId(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "kustutab konto ID jargi")
    public void removeAccountById(@RequestParam Integer id) {
        accountService.removeAccountById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "muudab konto andmed id jargi")
    public void updateAccountById(@RequestParam Integer id, @Valid @RequestBody AccountDto accountDto) {

    }

    @GetMapping("/last-name")
    public List<AccountResponse> findAccountsInfoByLastName(@RequestParam String lastName) {
        return accountService.findAccountsInfoById(lastName);


    }

}


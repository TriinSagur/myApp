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
    public AccountDto addNewAccount(@RequestBody @Valid AccountDto accountDto) {
        return accountService.addNewAccount(accountDto);


    }

    @GetMapping("/all")
    @Operation(summary = "Saame kontod")
    public List<AccountResponse> findAllAccounts() {
        return accountService.findAllAccounts();
    }


    @GetMapping("/id")
    @Operation(summary = "Otsib konto ID järgi (UUS)")
    public AccountResponse findAccountById(@RequestParam Integer id) {
        return accountService.findAccountInfoById(id);
    }


    @DeleteMapping("/id")
    @Operation(summary = "kustutame konto ID järgi")
    public void removeAccountById(@RequestParam Integer id) {
        accountService.removeAccountById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Uuendame kontot ID järgi")
    public void updateAccountById(@RequestParam Integer id, @RequestBody AccountDto accountDto) {
        accountService.updateAccountById(id, accountDto);
    }

    @GetMapping("/last-name")
    public List<AccountResponse> findAccountsInfoByLastName(@RequestParam String lastName) {
        return accountService.findAccountsInfoByLastName(lastName);
    }
}

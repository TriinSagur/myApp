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
    public AccountDto addNewAccount( @Valid @RequestBody AccountDto accountDto) {
        return accountService.addNewAccount(accountDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Näita kõiki kontosid")
    public List<AccountResponse> findAllAccounts() {
        return accountService.findAllAccounts();
    }

    @GetMapping("/id")
    @Operation(summary = "Otsib konto ID järgi (UUS)")
    public AccountResponse findAccountInfoById(@RequestParam Integer id) {
        return accountService.findAccountInfoById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Kustutab konto")
    public void removeAccountById(@RequestParam Integer id) {
        accountService.removeAccountById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Muudab konto")
    public void updateAccountById(@RequestParam Integer id, @RequestBody AccountDto accountDto) {
        accountService.updateAccountById(id, accountDto);
    }

    @GetMapping("/last-name")
    @Operation(summary = "Otsib perekonnanime järgi infot")
    public List<AccountResponse> findAccountsInfoByLastName(@RequestParam String lastName) {
        return accountService.findAccountsInfoByLastName(lastName);
    }
}

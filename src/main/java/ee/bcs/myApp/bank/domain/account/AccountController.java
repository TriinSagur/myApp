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
    @Operation (summary = "Tagastab Listi kõigist kontodest")
    public List<AccountResponse> findAllAccounts() {
        return accountService.findAllAccounts();
    }

    @GetMapping("/id")
    @Operation (summary = "Tagastab konto id järgi")
    public AccountResponse findAccountById(@RequestParam Integer id) {
        return accountService.findAccountInfoById(id);
    }

    @GetMapping("/customer-id")
    @Operation (summary = "Tagastab kontode info kliendi Id järgi")
        public List<AccountResponse> findAccountsInfoByCustomerId(@RequestParam Integer id) {
        return accountService.findAccountInfoByCustomerId(id);
    }

    @DeleteMapping ("/id")
    @Operation (summary = "Kustutab konto id järgi")
    public void removeAccountById(@RequestParam Integer id) {
        accountService.removeAccountById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Uuendab konto id järgi")
    public void updateAccountById(@RequestParam Integer id,@RequestBody AccountDto accountDto) {
        accountService.updateAccountById(id, accountDto);
    }

    @GetMapping("/last-name")
    @Operation(summary = "Leiab konto perekonnanime järgi")
    public List<AccountResponse> findAccountsInfoByLastName(@RequestParam String lastName) {
        return accountService.findAccountsInfoByLastName(lastName);
    }

}

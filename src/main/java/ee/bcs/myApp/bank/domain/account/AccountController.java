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
    @Operation(summary = "Tagastab kõik kliendid")
    public List<AccountResponse> findAllAccounts() { //get eeldab, et midagi peab tagasi ka tulema
        return accountService.findAllAccounts();
    }

    @GetMapping("/id")
    @Operation(summary = "Leiab konto info id järgi")
    public AccountResponse findAccountById(@RequestParam Integer id) {
        return accountService.findAccountInfo(id);
    }

    @GetMapping("/customer-id")
    @Operation(summary = "Leiab kontode info kliendi id järgi")
    public List<AccountResponse> findAccountsInfoByCustomerId(@RequestParam Integer id) {
        return accountService.findAccountsInfoByCustomerId(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Kustutab konto id järgi")
    public void removeAccountById(@RequestParam Integer id) {
        accountService.removeAccountById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Uuendab kontot id järgi")
    public void updateAccountById(@RequestParam Integer id, @Valid @RequestBody AccountDto accountDto) {
        accountService.updateAccountById(id, accountDto);
    }

    @GetMapping("/last-name")
    @Operation(summary = "Leiab konto kasutaja perekonna nime järgi")
    public List<AccountResponse> findAccountsInfoByLastName(@RequestParam String lastName) {
        return accountService.findAccountInfoByLastName(lastName);
    }
}

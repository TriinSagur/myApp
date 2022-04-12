package ee.bcs.myApp.bank.account;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping
    @Operation(summary = "Lisab uue konto")
    public AccountDto addNewAccount(@RequestBody AccountDto accountDto) {
        return accountService.addNewAccount(accountDto);
    }

    @GetMapping("/all")
    @Operation (summary = "Tagastab Listi kõigist kontodest")
    public List<AccountDto> findAllAccounts() {
        return accountService.findAllAccounts();
    }

    @GetMapping("/id")
    @Operation (summary = "Tagastab konto id järgi")
    public AccountDto findAccountById(@RequestParam Integer id) {
        return accountService.findAccountById(id);
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
}

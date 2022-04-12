package ee.bcs.myApp.bank.account;

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
    @Operation(summary = "Leiab kõik loodud kontod.")
    public List<AccountDto> findAllAccounts() {
        return accountService.findAllAccounts();
    }

    @GetMapping("/id")
    @Operation(summary = "Leiab konto andmebaasi ID järgi.")
    public AccountDto findAccountById(@RequestParam Integer id) {
        return accountService.findAccountById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Kustutab konto andmebaasi ID järgi.")
    public void removeAccountById(@RequestParam Integer id) {
        accountService.removeAccountById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Uuendab konto andmeid andmebaasi ID järgi.")
    public void updateAccountById(@RequestParam Integer id, @RequestBody @Valid AccountDto accountDto) {
        accountService.updateAccountById(id, accountDto);
    }

}

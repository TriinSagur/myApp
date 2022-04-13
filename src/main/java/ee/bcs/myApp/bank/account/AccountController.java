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
    @Operation(summary = "/Lisab uue konto")
    public AccountDto addNewAccount(@RequestBody @Valid AccountDto accountDto) {
        return accountService.addNewAccount(accountDto);

    }

    @GetMapping("/all")
    @Operation(summary= "Leiab kõik kontod")
    public List<AccountDto> findAllAccounts() {
        return accountService.findAllAccounts();
    }

    @GetMapping("/id")
    @Operation(summary = "Leiab konto id järgi")
    public AccountDto findAccountById(@RequestParam Integer id) {
        return accountService.findAccountById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Kustutab konto id järgi")
    public void deleteAccountById(@RequestParam Integer id) {
        accountService.deleteAccountById(id);
    }

}

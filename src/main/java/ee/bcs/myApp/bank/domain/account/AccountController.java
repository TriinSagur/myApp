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
    public Account.AccountDto addNewAccount(@Valid @RequestBody Account.AccountDto accountDto) {
    return accountService.addNewAccount(accountDto);
}

    @GetMapping("/all")
    public List<AccountResponse> findAllAccounts() {
        return accountService.findAllAccounts();
    }

   @GetMapping("/id")
   @Operation(summary = "Otsib konto info ID järgi")
   public AccountResponse findAccountById(@RequestParam Integer id) {
       return accountService.findAccountById(id);
 }


    @DeleteMapping("/id")
    public void removeAccountById(@RequestParam Integer id) {
        accountService.removeAccountById(id);
    }

        @PutMapping("/id")
        public void updateAccountByID (@RequestParam Integer id, @RequestParam Account.AccountDto accountDto) {
            accountService.updateAccountById(id, accountDto);
        }

        @GetMapping("/last_name")
        public List<AccountResponse> findAccountsInfoByLastName(String lastName) {
        return accountService.findAccountsInfoByLastName(lastName);
        }

    }


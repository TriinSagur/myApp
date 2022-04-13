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
    public AccountDto addNewAccount(@Valid @RequestBody AccountDto accountDto) {
        return accountService.addNewAccount(accountDto);
    }

//    @GetMapping("/all")
//    public List<AccountDto> findAllAccounts() {
//        return accountService.findAllAccounts();
//    }
//
    @GetMapping("/id")
    @Operation(summary = "Otsib konto ID järgi (UUS)")
    public AccountDto1 findAccountById(@RequestParam Integer id) {
        return accountService.findAccountById(id);
    }

    @GetMapping("/id/vana")
    @Operation(summary = "Otsib konto ID järgi (VANA)")
    public AccountDto findAccountByIdVANA(@RequestParam Integer id) {
        return new AccountDto();
    }



//
//    @DeleteMapping("/id")
//    public void removeAccountById(@RequestParam Integer id) {
//        accountService.removeAccountById(id);
//    }
//
//    @PutMapping("/id")
//    public void updateAccountById( @RequestParam Integer id, @RequestBody AccountDto accountDto) {
//        accountService.updateAccountById(id, accountDto);
//    }

}

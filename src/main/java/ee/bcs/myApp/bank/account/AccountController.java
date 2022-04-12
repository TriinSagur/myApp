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

    @GetMapping
    public List<AccountDto> findAllAccounts() {
        return accountService.findAllAccounts();
    }



}

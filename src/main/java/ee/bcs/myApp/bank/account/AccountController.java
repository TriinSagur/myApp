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

    @Resource
    private AccountEntityRepository repository;

    @PostMapping
    @Operation(summary = "Lisab uue konto")
    public AccountDto addNewAccount(@RequestBody @Valid AccountDto accountDto) {
        return accountService.addNewAccount(accountDto);

//        AccountEntity accountEntity = new AccountEntity();
//        accountEntity.setCustomer(accountDto.getCustomerId());
//        accountEntity.setAccountNumber(accountDto.getAccountNumber());
//        accountEntity.setBalance(accountDto.getBalance());
//        accountEntity.setLocked(accountDto.getLocked());
//        repository.save(accountEntity);
//        accountDto.setId(accountEntity.getId());
//        return accountDto;
    }

    @GetMapping("/all")
    @Operation(summary = "Tagastab kõik kliendid")
    public List<AccountDto> findAllAccounts() { //get eeldab, et midagi peab tagasi ka tulema
        return accountService.findAllAccounts();
    }

    @GetMapping("/id")
    @Operation(summary = "Leiab konto id järgi")
    public AccountDto findAccountById(@RequestParam Integer id) {
        return accountService.findAccountById(id);
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
}

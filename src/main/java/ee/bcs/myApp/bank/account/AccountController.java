//package ee.bcs.myApp.bank.account;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.models.security.SecurityScheme;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("/account")
//public class AccountController {
//
//    @Resource
//    private AccountService accountService;
////
////    @PostMapping
//    @Operation(summary = "Lisab uue konto")
//    public AccountDto addNewAccount( @Valid @RequestBody AccountDto accountDto) {
//        return accountService.addNewAccount(accountDto);
//    }
//
//    @GetMapping("/all")
//    @Operation(summary = "Näita kõiki kontosid")
//    public List<AccountDto> findAllAccounts() {
//        return accountService.findAllAccounts();
//    }
//
//    @GetMapping("/id")
//    @Operation(summary = "Leia konto")
//    public AccountDto findAccountById(@RequestParam Integer id) {
//        return accountService.findAccountById(id);
//    }
//
//    @DeleteMapping("/id")
//    @Operation(summary = "Kustutab konto")
//    public void removeAccountById(@RequestParam Integer id) {
//        accountService.removeAccountById(id);
//    }
//
//    @PutMapping("/id")
//    @Operation(summary = "Muudab konto")
//    public void updateAccountById(@RequestParam Integer id, @RequestBody AccountDto accountDto) {
//        accountService.updateAccountById(id, accountDto);
//    }
//}

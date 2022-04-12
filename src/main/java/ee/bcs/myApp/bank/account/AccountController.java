package ee.bcs.myApp.bank.account;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
// @RestController annab Springile märku, et siin klassis on mingid endpoint'id (controllerid)
@RestController
//  @RequestMapping'uga saab defineerida mingi pathi (raja) osa,
//  mis on iga SIIN KLASSIS oleva endpointi (controlleri) raja osa
//  ehk siis http://localhost:8080/account
@RequestMapping("/account")
public class AccountController {

    // Kui meie veebirakendus tõmmatakse käima, siis taustal toimetab servlet dispatcher,
    // kes teab kõiki meie controllerite endpoinide definitsioone
    // Kui see teema on veel endiselt segane, siis palun vaata uuesti "Spring HelloWorld":
    // https://youtu.be/pc9irBCk6rg


    // @Resource abiga saab Spring teha meile ligipääsu:
    // @Service, @Component, @Mapper, @Repository, jne annotatsiooniga klassidele
    @Resource
    private AccountService accountService;

    @PostMapping
    @Operation(summary = "Lisab uue konto")
    public AccountDto addNewAccount(@RequestBody AccountDto accountDto) {
        return accountService.addNewAccount(accountDto);
    }

}

package ee.bcs.myApp.bank.service;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Resource
    private BankService bankService;

    @PutMapping("/money-in")
    @Operation (summary = "Raha juurde lisamine kontole")
    public void deposit (@RequestBody @Valid DepositRequest request) {
        bankService.deposit(request);
    }

    @PutMapping("/money-out")
    @Operation (summary = "Raha välja võtmine kontolt")
    public void withdraw(@RequestBody WithdrawRequest request) {
        bankService.withdraw(request);

    }


}

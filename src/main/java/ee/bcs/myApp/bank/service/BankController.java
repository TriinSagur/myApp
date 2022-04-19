package ee.bcs.myApp.bank.service;

import ee.bcs.myApp.bank.domain.account.Account;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Resource
    private BankService bankService;

    @PostMapping
    @Operation(summary = "Raha juurde lisamine kontole")
    public void deposit(@RequestBody @Valid DepositRequest request) {
        bankService.deposit(request);
    }

    @PostMapping("money-out")
    @Operation(summary = "Raha väljavõtmine")
    public void withdraw(@RequestBody @Valid WithdrawRequest request) {
        bankService.withdraw(request);

    }

    @PostMapping("/")
    public ReceiveMoneyResponse receiveMoney(@Valid @RequestBody ReceiveMoneyRequest request){


    }
}

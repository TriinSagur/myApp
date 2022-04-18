package ee.bcs.myApp.bank.service;

import ee.bcs.myApp.bank.domain.account.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Resource
    private AccountService accountService;

    @Resource
    private BankService bankService;

    @PostMapping("/deposit")
    @Operation(summary = "Raha juurde lisamine kontole")
    public void deposit(@RequestBody @Valid DepositRequest request) {
        bankService.deposit(request);
    }

    @PostMapping("/withdraw")
    @Operation(summary = "Raha välja võtmine")
    public void withdraw(@RequestBody WithdrawRequest request) {
        bankService.withdraw(request);
    }

    @PostMapping("/in")
    public TransactionResponse receiveMoney(@RequestBody ReceiveMoneyRequest request) {
        return bankService.receiveMoney(request);
    }

    @PostMapping("/out")
    public TransactionResponse sendMoney(@RequestBody SendMoneyRequest request) {
        return bankService.sendMoney(request);
    }
}

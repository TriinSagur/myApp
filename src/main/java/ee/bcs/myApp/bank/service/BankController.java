package ee.bcs.myApp.bank.service;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/deposit")
    @Operation(summary = "raha juurdelisamine kontole")
    public void deposit(@RequestBody @Valid DepositRequest request) {
        bankService.deposit(request);
    }

    @PostMapping("/withdraw")
    @Operation(summary = "raha väljavõtmine  kontolt")
    public void withdraw(@RequestBody @Valid WithdrawRequest request) {
        bankService.withdraw(request);
    }

    @PostMapping("/in")
    @Operation(summary = "raha laekumine")
    private TransactionResponse recieveMoney(@Valid @RequestBody ReceiveMoneyRequest request) {
        return bankService.recieveMoney(request);

    }

    @PostMapping("/out")
    @Operation(summary = "raha väljamakse")
    private TransactionResponse sendMoney(@Valid @RequestBody SendMoneyRequest request) {
        return bankService.sendMoney(request);
    }
}

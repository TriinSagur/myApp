package ee.bcs.myApp.bank.service;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Resource
    private BankService bankService;

    @PostMapping("/deposit")
    @Operation(summary = "Raha kontole lisamine / ATM")
    public void deposit(@RequestBody @Valid DepositRequest request) {
        bankService.deposit(request);

    }

    @PostMapping("/withdraw")
    @Operation(summary = "Raha kontolt välja võtmine / ATM")
    public void withdraw(@RequestBody @Valid WithdrawRequest request) {
        bankService.withdraw(request);
    }

    @PostMapping("/in")
    @Operation(summary = "Raha laekumine mingilt kontolt")
    public TransactionResponse receiveMoney (@Valid @RequestBody MoneyRequest request) {
        return bankService.receiveMoney(request);
    }

    @PostMapping("/out")
    @Operation(summary = "Raha saatmine ühelt kontolt teisele")
    public TransactionResponse sendMoney(@Valid @RequestBody MoneyRequest request) {
        return bankService.sendMoney(request);
    }
}

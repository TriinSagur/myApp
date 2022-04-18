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

    @PostMapping("/money-in") // väldi tegusõnu
    @Operation(summary = "Raha lisamine kontole")
    public void deposit(@RequestBody @Valid DepositRequest request) {
        bankService.deposit(request);
    }

    @PostMapping("/money-out")
    @Operation(summary = "Raha võtmine kontolt")
    public void withdraw(@RequestBody @Valid WithdrawRequest request) {
        bankService.withdraw(request);
    }


}

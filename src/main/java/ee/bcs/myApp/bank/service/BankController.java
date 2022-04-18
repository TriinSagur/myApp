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
    @Operation(summary = "Raha juurde lisamine kontole")
    public void deposit(@Valid @RequestBody DepositRequest request) {
        bankService.deposit(request);
    }

    @PostMapping("/withdraw")
    public void withdraw(@Valid @RequestBody WithdrawRequest request) {
//        bankService.withdraw(request);

    }
}

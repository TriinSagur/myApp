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

    @PostMapping
    @Operation(summary = "Raha lisamine kontole")
    public void deposit(@RequestBody @Valid DepositRequest request) {

        bankService.deposit(request);
    }

    @PostMapping("/")
    public void withdraw(@RequestBody) {

    }
}


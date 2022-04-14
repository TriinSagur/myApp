package ee.bcs.myApp.bank.service;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Resource
    private BankService bankService;

    @PostMapping
    public void deposit(@RequestBody @Valid DepositRequest request) {
        bankService.deposit(request);
    }
}

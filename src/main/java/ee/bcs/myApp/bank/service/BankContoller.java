package ee.bcs.myApp.bank.service;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/bank")
public class BankContoller {

    @Resource
    private BankService bankService;

    @PostMapping
    public void deposit(@RequestBody DepositRequest depositRequest) {
        bankService.deposit(depositRequest);



    }


}

package ee.bcs.myApp.bank.service.transfer;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/bank")

public class TransferController {

    @Resource
    private TransferService transferService;


    @PostMapping("/deposit")
    @Operation(summary = "Raha juurde lisamine kontole")
    public void deposit(@Valid @RequestBody DepositRequest request) {
        transferService.deposit(request);
    }

    @PostMapping("/withdraw")
    @Operation(summary = "Raha kontolt valjavotmine")
    public void withdraw(@Valid @RequestBody WithdrawRequest request) {
        transferService.withdraw(request);
    }

    @PostMapping("/in")
    @Operation(summary = "Raha juurde teiselt kontolt")
    public TransferResponse receiveMoney(@Valid @RequestBody TransferRequest request) {
        return transferService.receiveMoney(request);
    }

    @PostMapping("/out")
    @Operation(summary = "Raha saatmine teisele kontole")
    public TransferResponse sendMoney(@Valid @RequestBody TransferRequest request) {
        return transferService.sendMoney(request);
    }
}

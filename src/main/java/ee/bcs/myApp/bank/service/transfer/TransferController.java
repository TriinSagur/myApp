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
    @Operation(summary = "Raha lisamine kontole / ATM")
    public void deposit(@RequestBody @Valid DepositRequest request) {
        transferService.deposit(request);
    }

    @PostMapping("/withdraw")
    @Operation(summary = "Raha väljastamine kontolt / ATM")
    public void withdraw(@RequestBody @Valid WithdrawRequest request) {
        transferService.withdraw(request);
    }

    @PostMapping("/receive")
    @Operation(summary = "Receive money")
    public TransferResponse receiveMoney(@RequestBody @Valid TransferRequest request) {
        return transferService.receiveMoney(request);
    }

    @PostMapping("/send")
    @Operation(summary = "Send money")
    public TransferResponse sendMoney(@RequestBody @Valid SendRequest request) {
        return transferService.sendMoney(request);
    }

}

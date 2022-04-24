package ee.bcs.myApp.bank.service.transfer;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/bank")
public class TransferController {

    @Resource
    private TransferService transferService;

    @PostMapping("/deposit")
    @Operation(summary = "Raha kontole lisamine / ATM")
    public void deposit(@RequestBody @Valid DepositRequest request) {
        transferService.deposit(request);

    }

    @PostMapping("/withdraw")
    @Operation(summary = "Raha kontolt välja võtmine / ATM")
    public void withdraw(@RequestBody @Valid WithdrawRequest request) {
        transferService.withdraw(request);
    }

    @PostMapping("/in")
    @Operation(summary = "Raha laekumine mingilt kontolt")
    public TransferResponse receiveMoney (@Valid @RequestBody TransferRequest request) {
        return transferService.receiveMoney(request);
    }

    @PostMapping("/out")
    @Operation(summary = "Raha saatmine ühelt kontolt teisele")
    public TransferResponse sendMoney(@Valid @RequestBody TransferRequest request) {
        return transferService.sendMoney(request);
    }
}

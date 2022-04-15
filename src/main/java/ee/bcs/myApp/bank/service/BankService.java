package ee.bcs.myApp.bank.service;

import ee.bcs.myApp.bank.domain.transaction.TransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BankService {

    @Resource
    private TransactionService transactionService;

    public void deposit(DepositRequest request) {
        transactionService.addDepositTransaction(request);

    }


}

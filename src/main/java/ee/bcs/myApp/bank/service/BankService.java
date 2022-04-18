package ee.bcs.myApp.bank.service;

import ee.bcs.myApp.bank.domain.account.AccountService;
import ee.bcs.myApp.bank.domain.transaction.TransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BankService {

    @Resource
    private TransactionService transactionService;

    @Resource
    private AccountService accountService;

    public void deposit(DepositRequest request) {

        transactionService.addDepositTransaction(request);
        accountService.updateCreditPaymentBalance(request.getAccountId(), request.getAmount());
    }


    public void withdraw(WithdrawRequest request) {
        transactionService.addWithdrawTransaction(request);
        accountService.updateDebitPaymentBalance(request.getAccountId(), request.getAmount());

    }
}

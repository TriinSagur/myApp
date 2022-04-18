package ee.bcs.myApp.bank.service;

import ee.bcs.myApp.bank.domain.account.AccountService;
import ee.bcs.myApp.bank.domain.transaction.Transaction;
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
        Transaction transaction = transactionService.addDepositTransaction(request);
        accountService.updateCreditPaymentBalance(transaction.getAccount(), request.getAmount());
    }

    public void withdraw(WithdrawRequest request) {
        Transaction transaction = transactionService.addWithdrawTransaction(request);
        accountService.updateDebitPaymentBalance(transaction.getAccount(), request.getAmount());
    }

    public TransactionResponse receiveMoney(ReceiveMoneyRequest request) {
        Transaction transaction = transactionService.addReceiveMoneyTransaction(request);
        accountService.updateCreditPaymentBalance(transaction.getAccount(), request.getAmount());
        return new TransactionResponse(transaction.getId());
    }

    public TransactionResponse sendMoney(SendMoneyRequest request) {
        transactionService.addSendMoneyTransaction(request);
        return null;
    }
}

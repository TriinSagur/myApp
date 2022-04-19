package ee.bcs.myApp.bank.service;

import ee.bcs.myApp.bank.domain.account.Account;
import ee.bcs.myApp.bank.domain.account.AccountService;
import ee.bcs.myApp.bank.domain.transaction.Transaction;
import ee.bcs.myApp.bank.domain.transaction.TransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BankService {

    @Resource
    private AccountService accountService;

    @Resource
    private TransactionService transactionService;

    public void deposit(DepositRequest request) {
        Transaction transaction = transactionService.addDepositTransaction(request);
        accountService.updateCreditPaymentBalance(transaction.getAccount(), request.getAmount());
    }
    public void withdraw(WithdrawRequest request){
        Transaction transaction = transactionService.addWithdrawTransaction(request);
        accountService.updateDebitPaymentBalance(transaction.getAccount(), request.getAmount());
    }
    public ReceiveMoneyResponse receiveMoney(ReceiveMoneyRequest request){
       Transaction transaction = transactionService.addReceiveMoneyTransaction(request);
        accountService.findAccountByAccountNumber(request.getAccount(), request.getAmount());
        return new ReceiveMoneyResponse();

    }

}

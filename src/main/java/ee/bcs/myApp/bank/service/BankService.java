package ee.bcs.myApp.bank.service;

import ee.bcs.myApp.bank.domain.account.AccountService;
import ee.bcs.myApp.bank.domain.transaction.Transaction;
import ee.bcs.myApp.bank.domain.transaction.TransactionService;
import ee.bcs.myApp.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BankService {

    @Resource
    private TransactionService transactionService;

    @Resource
    private AccountService accountService;

    @Resource
    private ValidationService validationService;

    public void deposit(DepositRequest request) {
        validationService.isValidDepositAmount(request.getAmount());
        Transaction transaction = transactionService.addDepositTransaction(request);
        accountService.updateCreditPaymentBalance(transaction.getAccount(), request.getAmount());
    }

    public void withdraw(WithdrawRequest request) {
        validationService.isValidWithdrawAmount(request.getAmount());
        Transaction transaction = transactionService.addWithdrawTransaction(request);
        accountService.updateDebitPaymentBalance(transaction.getAccount(), request.getAmount());
    }

    public TransactionResponse receiveMoney(MoneyRequest request) {
        Transaction transaction = transactionService.addReceiveMoneyTransaction(request);
        accountService.updateCreditPaymentBalance(transaction.getAccount(), request.getAmount());
        return new TransactionResponse(transaction.getId());
    }

    public TransactionResponse sendMoney(MoneyRequest request) {
        Transaction transaction = transactionService.addSendMoneyTransaction(request);
        return new TransactionResponse(transaction.getId());
    }
}

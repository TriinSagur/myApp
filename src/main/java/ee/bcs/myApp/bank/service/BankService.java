package ee.bcs.myApp.bank.service;

import ee.bcs.myApp.bank.domain.account.Account;
import ee.bcs.myApp.bank.domain.account.AccountService;
import ee.bcs.myApp.bank.domain.transaction.TransactionMapper;
import ee.bcs.myApp.bank.domain.transaction.TransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transaction;

@Service
public class BankService {


    @Resource
    private TransactionService transactionService;

    @Resource
    private TransactionMapper transactionMapper;

    @Resource
    private AccountService accountService;

    public void deposit(DepositRequest request) {
        Transaction transaction = transactionMapper.toDepositEntity(request);
        Account account = accountService.findAccountById(request.getAccountId());
        transaction.setReceiverAccountNumber(account.getAccountNumber());
        transaction.setBalance(account.getBalance() + request.getAmount());
        transaction.setTransactionDateTime(LocalDateTime.now());
//        transaction.setReceiverAccountNumber();

    }
}



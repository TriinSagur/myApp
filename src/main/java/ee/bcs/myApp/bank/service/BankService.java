package ee.bcs.myApp.bank.service;

import ee.bcs.myApp.bank.domain.account.Account;
import ee.bcs.myApp.bank.domain.account.AccountService;
import ee.bcs.myApp.bank.domain.transaction.Transaction;
import ee.bcs.myApp.bank.domain.transaction.TransactionMapper;
import ee.bcs.myApp.bank.domain.transaction.TransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class BankService {

@Resource
private TransactionService transactionService;


    public void deposit(DepositRequest request) {
        transactionService.addDepositTransaction(request);
        //transactionService.addNewTransaction();
    }


}

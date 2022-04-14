package ee.bcs.myApp.bank.service;

import ee.bcs.myApp.bank.transaction.Transaction;
import ee.bcs.myApp.bank.transaction.TransactionMapper;
import ee.bcs.myApp.bank.transaction.TransactionService;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BankService {

    @Resource
    private TransactionService transactionService;

    @Resource
    private TransactionMapper transactionMapper;

    public void deposit(DepositRequest request) {
        Transaction transaction = transactionMapper.toDepositEntity(request);

        System.out.println();
//        transactionService.addNewTransaction(new Transaction());
    }
}

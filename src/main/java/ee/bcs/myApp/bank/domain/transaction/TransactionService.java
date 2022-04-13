package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.domain.account.Account;
import ee.bcs.myApp.bank.service.DepositRequest;

import javax.annotation.Resource;
import java.time.Instant;

public class TransactionService {

    @Resource
    private TransactionService transactionService;

    @Resource
    private TransactionMapper transactionMapper;

    @Resource
    private TransactionRepository transactionRepository;

    public void deposit(DepositRequest request) {
        Transaction transaction = transactionMapper.toDepositEntity(request);
        Account account = accountService.findAccountById(request.getAccountId());
        transaction.setReceiverAccountNumber(account.getAccountNumber());
        transaction.setBalance(account.getBalance() + request.getAmount());
        transaction.setTransactionDateTime(Instant.now());
        transaction.setAccount(account);
        transactionRepository.save(transaction);
    }
}

package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.domain.account.Account;
import ee.bcs.myApp.bank.domain.account.AccountRepository;
import ee.bcs.myApp.bank.domain.account.AccountService;
import ee.bcs.myApp.bank.service.DepositRequest;
import ee.bcs.myApp.bank.service.ReceiveMoneyRequest;
import ee.bcs.myApp.bank.service.SendMoneyRequest;
import ee.bcs.myApp.bank.service.WithdrawRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;

@Service
public class TransactionService {


    @Resource
    private AccountService accountService;

    @Resource
    private AccountRepository accountRepository;

    @Resource
    private TransactionMapper transactionMapper;

    @Resource
    private TransactionRepository transactionRepository;

    public Transaction addDepositTransaction(DepositRequest request) {
        Transaction transaction = transactionMapper.toDepositEntity(request);
        Account account = accountService.findAccountById(request.getAccountId());
        transaction.setReceiverAccountNumber(account.getAccountNumber());
        transaction.setBalance(account.getBalance() + request.getAmount());
        transaction.setTransactionDateTime(Instant.now());
        transaction.setAccount(account);
        transactionRepository.save(transaction);
        return transaction;
//        TODO: pigem teha eraldi meetod
//        account.setBalance(account.getBalance() + request.getAmount());
//        accountRepository.save(account);

    }

    public Transaction addWithdrawTransaction(WithdrawRequest request) {
        Transaction transaction = transactionMapper.toWithdrawEntity(request);
        Account account = accountService.findAccountById(request.getAccountId());
        transaction.setSenderAccountNumber(account.getAccountNumber());
        transaction.setBalance(account.getBalance() - request.getAmount());
        transaction.setTransactionDateTime(Instant.now());
        transaction.setAccount(account);
        transactionRepository.save(transaction);
        return transaction;
    }

    public Transaction addReceiveMoneyTransaction(ReceiveMoneyRequest request) {
        Transaction transaction = transactionMapper.toReceiveMoneyEntity(request);
        Account account = accountService.findAccountByAccountNumber(request.getReceiverAccountNumber());
        transaction.setBalance(account.getBalance() + request.getAmount());
        transaction.setAccount(account);
        transaction.setTransactionDateTime(Instant.now());
        transactionRepository.save(transaction);
        return transaction;
    }

    public Transaction addSendMoneyTransaction(SendMoneyRequest request) {
        Transaction transaction = transactionMapper.toSendMoneyEntity(request);
        Account senderAccount = accountService.findAccountById(request.getSenderAccountId());

        if (accountService.accountExistByAccountNumber(request.getReceiverAccountNumber())) {
//            todo: kui eksisteerin siis 2 transaktsiooni
            Account receiverAccount = accountService.findAccountByAccountNumber(request.getReceiverAccountNumber());


        } else {
//            todo: 1 transaktsioon


        }

        return null;
    }
}

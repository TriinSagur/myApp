package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.domain.account.Account;
import ee.bcs.myApp.bank.domain.account.AccountRepository;
import ee.bcs.myApp.bank.domain.account.AccountService;
import ee.bcs.myApp.bank.service.DepositRequest;
import ee.bcs.myApp.bank.service.ReceiveMoneyRequest;
import ee.bcs.myApp.bank.service.WithdrawRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;

@Service
public class TransactionService {

    @Resource
    private AccountService accountService;

    @Resource
    private TransactionMapper transactionMapper;

    @Resource
    private TransactionRepository transactionRepository;

    public Transaction addDepositTransaction(DepositRequest request) {
        Transaction transaction = transactionMapper.toDepositEntity(request);
        Account account = accountService.findAccountById(request.getAccountId());
        Integer newBalance = calculateCreditBalance(account.getBalance(), request.getAmount());
        transaction.setReceiverAccountNumber(account.getAccountNumber());
        saveBankTransaction(request, transaction, account);
        return transaction;
    }

    public Transaction addWithdrawTransaction(WithdrawRequest request) {
        Transaction transaction = transactionMapper.toWithdrawEntity(request);
        Account account = accountService.findAccountById(request.getAccountId());
        Integer newBalance = account.getBalance() - request.getAmount();
        transaction.setSenderAccountNumber(account.getAccountNumber());

        saveBankTransaction(request, transaction, account);
        return transaction;
    }




    public Transaction addReceiveMoneyTransaction(ReceiveMoneyRequest request) {
        Transaction transaction = transactionMapper.toReceiveMoneyEntity(request);
        Account account = accountService.findAccountByAccountNumber(request.getReceiverAccountNumber());
        Integer newBalance = account.getBalance() + request.getAmount();

        saveBankTransaction(request, transaction, account);

        return transaction;
    }



    public Transaction addSendMoneyTransaction(SendMoneyRequest request) {
        Transaction senderTransaction = transactionMapper.toSendMoneyEntity(request);
        Account senderAccount = accountService.findAccountById(request.getSenderAccountId());
        Integer senderNewBalance = calculateDebitBalance(senderAccount.getBalance(), request.getAmount());
        saveBankTransaction(senderTransaction, senderNewBalance, senderAccount);

        if (accountService.acccountExistsByAccountNumber(request.getReceverAccountNumber())) {
            // todo : kui eksisteerib, siis 2 tehingut
            accountService.findAccountByAccountNumber(request.getReceiverAccount);

        } else {
            // sender või recveiver

        }
    }
    private void saveBankTransaction(DepositRequest request, Transaction transaction, Account account) {
        transaction.setBalance(calculateCreditBalance(request, account));
        transaction.setTransactionDateTime(Instant.now());
        transaction.setAccount(account);
        transactionRepository.save(transaction);
    }

    private Integer calculateCreditBalance(Integer balance, Integer amount) {
        return balance + amount;
    }

    private Integer calculateDebitBalance(Integer balance, Integer amount) {
        return balance - amount;
    }

    private void saveBankTransaction(WithdrawRequest request, Transaction transaction, Account account) {
        transaction.setBalance(calculateDebitBalance(request, account));
        transaction.setTransactionDateTime(Instant.now());
        transaction.setAccount(account);
        transactionRepository.save(transaction);
    }

    private void saveBankTransaction(ReceiveMoneyRequest request, Transaction transaction, Account account) {
        transaction.setBalance(account.getBalance() + request.getAmount());
        transaction.setTransactionDateTime(Instant.now());
        transaction.setAccount(account);
        transactionRepository.save(transaction);
    }


}

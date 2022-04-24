package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.service.statement.Statement;
import ee.bcs.myApp.bank.service.transfer.DepositRequest;
import ee.bcs.myApp.bank.service.transfer.TransferRequest;
import ee.bcs.myApp.bank.service.transfer.WithdrawRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-22T12:16:37+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction toDepositEntity(DepositRequest request) {
        if ( request == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setAmount( request.getAmount() );

        transaction.setSenderAccountNumber( "ATM" );
        transaction.setType( "d" );

        return transaction;
    }

    @Override
    public Transaction toWithdrawEntity(WithdrawRequest request) {
        if ( request == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setAmount( request.getAmount() );

        transaction.setReceiverAccountNumber( "ATM" );
        transaction.setType( "w" );

        return transaction;
    }

    @Override
    public Transaction toReceiveMoneyEntity(TransferRequest request) {
        if ( request == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setSenderAccountNumber( request.getSenderAccountNumber() );
        transaction.setReceiverAccountNumber( request.getReceiverAccountNumber() );
        transaction.setAmount( request.getAmount() );

        transaction.setType( "r" );

        return transaction;
    }

    @Override
    public Transaction toSendMoneyEntity(TransferRequest request) {
        if ( request == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setSenderAccountNumber( request.getSenderAccountNumber() );
        transaction.setReceiverAccountNumber( request.getReceiverAccountNumber() );
        transaction.setAmount( request.getAmount() );

        transaction.setType( "s" );

        return transaction;
    }

    @Override
    public List<Statement> toStatements(List<Transaction> transactions) {
        if ( transactions == null ) {
            return null;
        }

        List<Statement> list = new ArrayList<Statement>( transactions.size() );
        for ( Transaction transaction : transactions ) {
            list.add( transactionToStatement( transaction ) );
        }

        return list;
    }

    protected Statement transactionToStatement(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        Statement statement = new Statement();

        statement.setId( transaction.getId() );
        statement.setSenderAccountNumber( transaction.getSenderAccountNumber() );
        statement.setReceiverAccountNumber( transaction.getReceiverAccountNumber() );
        statement.setAmount( transaction.getAmount() );
        statement.setBalance( transaction.getBalance() );
        statement.setTransactionDateTime( transaction.getTransactionDateTime() );

        return statement;
    }
}

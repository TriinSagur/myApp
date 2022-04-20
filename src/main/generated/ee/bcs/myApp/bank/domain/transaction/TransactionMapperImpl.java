package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.service.DepositRequest;
import ee.bcs.myApp.bank.service.MoneyRequest;
import ee.bcs.myApp.bank.service.WithdrawRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-19T12:27:12+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
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
    public Transaction toReceiveMoneyEntity(MoneyRequest result) {
        if ( result == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setSenderAccountNumber( result.getSenderAccountNumber() );
        transaction.setReceiverAccountNumber( result.getReceiverAccountNumber() );
        transaction.setAmount( result.getAmount() );

        transaction.setType( "r" );

        return transaction;
    }

    @Override
    public Transaction toSendMoneyEntity(MoneyRequest result) {
        if ( result == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setSenderAccountNumber( result.getSenderAccountNumber() );
        transaction.setReceiverAccountNumber( result.getReceiverAccountNumber() );
        transaction.setAmount( result.getAmount() );

        transaction.setType( "s" );

        return transaction;
    }
}

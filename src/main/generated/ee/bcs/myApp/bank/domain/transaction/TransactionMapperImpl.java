package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.service.DepositRequest;
import ee.bcs.myApp.bank.service.ReceiveMoneyRequest;
import ee.bcs.myApp.bank.service.WithdrawRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-18T14:36:32+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Amazon.com Inc.)"
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
    public Transaction toReceiveMoneyEntity(ReceiveMoneyRequest request) {
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
}

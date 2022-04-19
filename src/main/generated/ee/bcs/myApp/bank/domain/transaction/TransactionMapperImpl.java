package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.service.DepositRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-18T09:38:04+0300",
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
}

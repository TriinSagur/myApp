package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.service.DepositRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TransactionMapper {
//    @Mapping(source = "accountId", target = "account.id")
//    @Mapping(source = "accountCustomerId", target = "customer.id")
//    @Mapping(source = "accountCustomerFirstName", target = "customer.firstName")
//    @Mapping(source = "accountCustomerLastName", target = "customer.lastName")
//    @Mapping(source = "accountCustomerIsikukood", target = "customer.isikukood")
//    @Mapping(source = "accountAccountNumber", target = "account.accountNumber")
//    @Mapping(source = "accountBalance", target = "account.balance")
//    @Mapping(source = "accountLocked", target = "account.locked")
//    Transaction transactionDtoToTransaction(TransactionDto transactionDto);

    @Mapping(target = "senderAccountNumber", constant = "ATM")
    @Mapping(target = "type", constant = "d")
    Transaction toDepositEntity(DepositRequest request);


}

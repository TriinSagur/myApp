package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.service.DepositRequest;
import ee.bcs.myApp.bank.service.MoneyRequest;
import ee.bcs.myApp.bank.service.WithdrawRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TransactionMapper {

    @Mapping(target = "senderAccountNumber", constant = "ATM")
    @Mapping(target = "type", constant = "d")
    Transaction toDepositEntity(DepositRequest request);

    @Mapping(target = "receiverAccountNumber", constant = "ATM")
    @Mapping(target = "type", constant = "w")
    Transaction toWithdrawEntity(WithdrawRequest request);

    @Mapping(target = "type", constant = "r")
    Transaction toReceiveMoneyEntity(MoneyRequest request);
    
    @Mapping(target = "type", constant = "s")
    Transaction toSendMoneyEntity(MoneyRequest request);
}

package ee.bcs.myApp.bank.account;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountMapper {
//    Account toEntity(AccountDto1 accountDto1);


//    private final Integer customerId;
//    private String firstName;
//    private String lastName;
//    private String isikukood;
//    private final String accountNumber;
//    private final Integer balance;
//    private final Boolean locked;


    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "firstName", source = "customer.firstName")
    @Mapping(target = "lastName", source = "customer.lastName")
    @Mapping(target = "isikukood", source = "customer.isikukood")
    AccountResponse toResponse(Account account);

    List<AccountResponse> toResponses(List<Account> accounts);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target="id", ignore = true)
    void updateEntity(AccountDto accountDto1, @MappingTarget Account account);

}

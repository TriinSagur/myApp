package ee.bcs.myApp.bank.account;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountMapper {
    Account toEntity(AccountDto accountDto);

//    private Integer customerId;
//    private String firstName;
//    private String lastName;
//    private String isikukood;
//    private String accountNumber;
//    private Integer balance;
//    private Boolean locked;

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "firstName", source = "customer.firstName")
    @Mapping(target = "lastName", source = "customer.lastName")
    @Mapping(target = "isikukood", source = "customer.isikukood")
    @Mapping(target = "accountNumber", source = "accountNumber")

    AccountResponse toResponse(Account account);

    List<AccountResponse> toResponses(List<Account> account);





    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void upadeteEntity(AccountDto accountDto1, @MappingTarget Account account);
}

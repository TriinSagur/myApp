package ee.bcs.myApp.bank.account;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountMapper {
    Account toEntity(AccountDto1 accountDto1);

    private Integer customerId;
    private String firstName;
    private String lastName;
    private String isikukood;
    private String accountNumber;
    private Integer balance;
    private Boolean locked;


    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "firstName", source = "customer.firstName")
    @Mapping(target = "lastName", source = "customer.lastName")
    @Mapping(target = "isikokood", source = "customer.isikukood")
    @Mapping(target = "accountNumber", source = "accountNumber")
    AccountResponse toResponse(Account account);

    List<AccountResponse>  toResponse(List<Account> account);


    AccountDto1 accountToAccountDto1(Account account);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAccountFromAccountDto1(AccountDto1 accountDto1, @MappingTarget Account account);
}

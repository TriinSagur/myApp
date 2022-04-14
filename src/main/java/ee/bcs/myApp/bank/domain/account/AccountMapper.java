package ee.bcs.myApp.bank.domain.account;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountMapper {
    Account toEntity(AccountDto accountDto1);

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
    AccountResponse toResponse(Account account);

    List<AccountResponse> toResponses(List<Account> account);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(AccountDto accountDto, @MappingTarget Account account);
}

package ee.bcs.myApp.bank.account;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountMapper {
    Account toEntity (AccountDto1 accountDto1);

//    private Integer customerId;
//    private String firstName;
//    private String lastName;
//    private String isikukood;
//    private String accountNumber;
//    private Integer balance;
//    private Boolean locked;
    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "firstName", source = "customer.firstName")
    @Mapping(target = "lastName",  source = "customer.lastName")
    @Mapping(target = "isikukood",  source = "customer.isikukood")
    AccountResponse toResponse(Account account);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(AccountDto1 accountDto1, @MappingTarget Account account);
}

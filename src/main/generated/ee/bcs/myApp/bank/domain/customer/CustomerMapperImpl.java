package ee.bcs.myApp.bank.domain.customer;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-17T09:56:56+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14 (Amazon.com Inc.)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toEntity(CustomerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setFirstName( dto.getFirstName() );
        customer.setLastName( dto.getLastName() );
        customer.setIsikukood( dto.getIsikukood() );

        return customer;
    }

    @Override
    public CustomerDto toDto(Customer entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( entity.getId() );
        customerDto.setFirstName( entity.getFirstName() );
        customerDto.setLastName( entity.getLastName() );
        customerDto.setIsikukood( entity.getIsikukood() );

        return customerDto;
    }

    @Override
    public List<CustomerDto> toDtos(List<Customer> customers) {
        if ( customers == null ) {
            return null;
        }

        List<CustomerDto> list = new ArrayList<CustomerDto>( customers.size() );
        for ( Customer customer : customers ) {
            list.add( toDto( customer ) );
        }

        return list;
    }

    @Override
    public void updateEntity(CustomerDto dto, Customer entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getFirstName() != null ) {
            entity.setFirstName( dto.getFirstName() );
        }
        if ( dto.getLastName() != null ) {
            entity.setLastName( dto.getLastName() );
        }
        if ( dto.getIsikukood() != null ) {
            entity.setIsikukood( dto.getIsikukood() );
        }
    }
}

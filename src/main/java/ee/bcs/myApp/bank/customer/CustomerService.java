package ee.bcs.myApp.bank.customer;

import ee.bcs.myApp.MyAppApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    // See meetod on defineeritud nii, et ta võtab sisse CustomerDto objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod peab tagastama CustomerDto tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public CustomerDto addNewCustomer(CustomerDto customerDto) {
        // Võtame addNewCustomer() signatuuri parameetris sisse CustomerDto tüüpi objekti
        // Siin signatuuris antakse sellele objekti muutujale nimeks 'customerDto'

        // Siin vaatleme kõigepealt paremat poolt. Kutsutakse välja meetod toEntity(), mis on defineeritud siin samas klassis
        // toEntity() on põhimõtteliselt mäpper meetod "Dto -> Entity"
        // toEntity võtab parameetrina Dto klassi tüüpi objekti (Data Transfer Object - andmete liigutamiseks mõeldud klass)
        // ja tagastab -> Entity (andmebaasi tabeli jaoks mõeldud klass)
        // toEntity() poolt tagastatud tulemus pannakse muutujasse 'customer'
        Customer customer = toEntity(customerDto);

        // Siin kutsutakse välja meetod, mis on ära defineerutud Customer klassi sees.
        // See on meie enda poolt välja mõeldud meetod millega toimetame selle konkreetse objekti andmetega
        // Anname seal objektis 'id' väljale 'idCounter' väärtuse
        // Seejärel suurendame idCounteri suurust ühe võrra
        // Vaata seda meetodit Customer klassis.
        customer.updateId();

        // MyAppApplication klassis on public static muutuja. Sellise muutuja sisu on täpselt see sama,
        // kus iganes me ka seda ei kasuta. Kasutame seda lihtsalt andmebaasi simuleerimiseks.
        // Tulemus päritakse getteri abil välja ja siis pannakse tulemus muutujasse.
        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();

        // Listi 'customers' lisatakse (add) juurde üks objekt 'customer'
        // Kui List'i teema on veel endiselt segane, siis palun vaata uuesti:
        // https://youtu.be/EWRXMPLvgyM
        customers.add(customer);

        // Siin vaatleme kõigepealt "return'i" paremat poolt. Kutsutakse välja meetod toDto(), mis on defineeritud siin samas klassis
        // toDto() on põhimõtteliselt mäpper meetod "Entity -> Dto"
        // Sisse võtab parameetrina Entity (andmebaasi tabeli jaoks mõeldud klass)
        // ja tagastab -> Dto (Data Transfer Object) andmete liigutamiseks mõeldud klass
        // Tagastame RETURN statement'iga 'toDto()' tulemuse
        // Peale return'i minnakse sellest defineeritud getTransactionsByAccountId() meetodist välja
        return toDto(customer);
    }


    // See meetod on defineeritud nii, et mingeid parameetreid (andmeid) ta sisse ei võta
    // See meetod peab tagastama List<CustomerDto> tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public List<CustomerDto> getAllCustomers() {

        // MyAppApplication klassis on public static muutuja. Sellise muutuja sisu on täpselt see sama,
        // kus iganes me ka seda ei kasuta. Kasutame seda lihtsalt andmebaasi simuleerimiseks.
        // Tulemus päritakse getteri abil välja ja siis pannakse tulemus muutujasse.
        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();

        // Kogu selle 'getAllCustomers' meetodiga peab tagastama List<CustomerDto> tüüpi objekti
        // Me siis peame looma sellise tühja objekti/keha, et meil oleks võimalik kuhugi elemente juurde lisada.
        List<CustomerDto> customerDtos = new ArrayList<>();


        // Teeme for tsükkli kõikide klientide kohta ('customer'), mis on Listis
        // Kui Listide for tsükli teema on veel endiselt segane, siis palun vaata uuesti "FOR tsükkel List":
        // https://youtu.be/wxA_vwf6Y3k
        // Käime kõik kontod läbi ('customers') ja lisame igal tsükklil ühe objekti 'customer' muutujasse
        // for tsükli ALGUS
        for (Customer customer : customers) {

            // Siin vaatleme kõigepealt paremat poolt. Kutsutakse välja meetod toDto(), mis on defineeritud siin samas klassis
            // toDto() on põhimõtteliselt mäpper meetod "Entity -> Dto"
            // Sisse võtab parameetrina Entity (andmebaasi tabeli jaoks mõeldud klass)
            // ja tagastab -> Dto (Data Transfer Object) andmete liigutamiseks mõeldud klass
            CustomerDto customerDto = toDto(customer);

            // Listi 'customerDtos' lisatakse (add) juurde üks objekt 'customerDto'
            // Kui List'i teema on veel endiselt segane, siis palun vaata uuesti:
            // https://youtu.be/EWRXMPLvgyM
            customerDtos.add(customerDto);
        }
        // for tsükli LÕPP

        // Tagastame RETURN statement'iga 'customerDtos' objekti
        // Peale return'i minnakse sellest defineeritud meetodist välja
        return customerDtos;
    }

    // See meetod on defineeritud nii, et ta võtab sisse Integer objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle id-ga kuidagi toimetada.
    // See meetod peab tagastama CustomerDto tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public CustomerDto findCustomerById(Integer id) {
        // Võtame findCustomerById() signatuuri parameetris sisse Integer tüüpi objekti
        // Siin signatuuris antakse sellele objektidele nimeks 'id'
        // id = konto ID mis on meie Bank klassis 'customers' Listi objektide ühe elemendi ID hulggas


        // Siin vaatleme kõigepealt paremat poolt.
        // Kutsutakse välja meetod findCustomerEntityById(), mis on defineeritud siin samas klassis.
        // Sisse võtab parameetrina id
        // ja tagastab Customer tüüpi objekti.
        // Tulemus pannakse muutujasse result
        Customer result = findCustomerEntityById(id);

        // Siin vaatleme kõigepealt "return'i" paremat poolt. Kutsutakse välja meetod toDto(), mis on defineeritud siin samas klassis
        // toDto() on põhimõtteliselt mäpper meetod "Entity -> Dto"
        // Sisse võtab parameetrina Entity (andmebaasi tabeli jaoks mõeldud klass)
        // ja tagastab -> Dto (Data Transfer Object) andmete liigutamiseks mõeldud klass
        // Tagastame RETURN statement'iga 'toDto()' tulemuse
        // Peale return'i minnakse sellest defineeritud getTransactionsByAccountId() meetodist välja
        return toDto(result);
    }

    // See meetod on defineeritud nii, et ta võtab sisse Integer objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objektidega kuidagi toimetada.
    // See meetod peab tagastama Customer tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    private Customer findCustomerEntityById(Integer id) {

        // MyAppApplication klassis on public static muutuja. Sellise muutuja sisu on täpselt see sama,
        // kus iganes me ka seda ei kasuta. Kasutame seda lihtsalt andmebaasi simuleerimiseks.
        // Tulemus päritakse getteri abil välja ja siis pannakse tulemus muutujasse.
        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();

        // Loome uue Customer tüüpi objekti 'result'
        // See on siis see objekt, mida meie meetod findCustomerEntityById() hakkab hiljem return'iga tagastama
        Customer result = new Customer();

        // Teeme for tsükkli kõikide klientide kohta ('customer'), mis on Listis
        // Kui Listide for tsükli teema on veel endiselt segane, siis palun vaata uuesti "FOR tsükkel List":
        // https://youtu.be/wxA_vwf6Y3k
        // Käime kõik kontod läbi ('customers') ja lisame igal tsükklil ühe objekti 'customer' muutujasse
        // for tsükli ALGUS
        for (Customer customer : customers) {

            // Kui 'customer' objekti field/väli 'id' (saadakse getteri abil) on võrdne selle meetodi findCustomerEntityById parameetriga 'id',
            // siis minnakse if koodibloki sisse
            if (customer.getId().equals(id)) {

                // result muutujasse pannakse see customer objekt
                result = customer;
            }
        }
        // for tsükli LÕPP

        // Tagastame RETURN statement'iga 'result' objekti
        // Peale return'i minnakse sellest defineeritud meetodist välja
        return result;
    }

    // See meetod on defineeritud nii, et ta võtab sisse Integer objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objektidega kuidagi toimetada.
    // See meetod on void tüüpi. Ta ei tagasta midagi. Puudub RETURN statement
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public void removeCustomerById(Integer id) {

        // MyAppApplication klassis on public static muutuja. Sellise muutuja sisu on täpselt see sama,
        // kus iganes me ka seda ei kasuta. Kasutame seda lihtsalt andmebaasi simuleerimiseks.
        // Tulemus päritakse getteri abil välja ja siis pannakse tulemus muutujasse.
        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();

        // Loome uue Customer tüüpi objekti 'result'
        // See on siis see objekt, mida meie meetod removeCustomerById() hakkab hiljem return'iga tagastama
        Customer result = new Customer();

        // Teeme for tsükkli kõikide klientide kohta ('customer'), mis on Listis
        // Kui Listide for tsükli teema on veel endiselt segane, siis palun vaata uuesti "FOR tsükkel List":
        // https://youtu.be/wxA_vwf6Y3k
        // Käime kõik kontod läbi ('customers') ja lisame igal tsükklil ühe objekti 'customer' muutujasse
        // for tsükli ALGUS
        for (Customer customer : customers) {
            // Kui 'customer' objekti field/väli 'id' (saadakse getteri abil) on võrdne selle meetodi removeCustomerById parameetriga 'id',
            // siis minnakse if koodibloki sisse
            if (customer.getId().equals(id)) {

                // result muutujasse pannakse see customer objekt
                result = customer;
            }
        }
        // for tsükli L}PP

        // kasutame listi meetodit remove(), millega eemaldatakse listist sisse antav objekt
        customers.remove(result);
    }

    public void updateCustomerById(Integer id, CustomerDto customerDto) {
        Customer customer = findCustomerEntityById(id);
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setIsikukood(customerDto.getIsikukood());
    }


    private CustomerDto toDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setIsikukood(customer.getIsikukood());
        return customerDto;
    }

    private Customer toEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setIsikukood(customerDto.getIsikukood());
        return customer;
    }
}

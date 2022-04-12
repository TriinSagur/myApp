package ee.bcs.myApp.bank.customer;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

// @RestController annab Springile märku, et siin klassis on mingid endpoint'id (controllerid)
@RestController
//  @RequestMapping'uga saab defineerida mingi pathi (raja) osa,
//  mis on iga SIIN KLASSIS oleva endpointi (controlleri) raja osa
//  ehk siis http://localhost:8080/customer
@RequestMapping("/customer")
public class CustomerController {

    // Kui meie veebirakendus tõmmatakse käima, siis taustal toimetab servlet dispatcher,
    // kes teab kõiki meie controllerite endpoinide definitsioone
    // Kui see teema on veel endiselt segane, siis palun vaata uuesti "Spring HelloWorld":
    // https://youtu.be/pc9irBCk6rg


    // @Resource abiga saab Spring teha meile ligipääsu:
    // @Service, @Component, @Mapper, @Repository, jne annotatsiooniga klassidele
    @Resource
    private CustomerService customerService;

    // Kui meie veebiserverisse tuleb sisse http päring 'POST' 'http://localhost:8080/customer'
    // siis käivitatakse selle mäppingu all olev meetod addNewCustomer()
    // Kuna addNewCustomer() meetod, on defineeritud nii, et see tagastab CustomerDto tüüpi objekti,
    // siis return'is peab olema CustomerDto tüüpi objekt
    // Kuna meetodi parameetris on ära defineeritud @RequestBody CustomerDto tüüpi objekt,
    // siis Spring annab endast parima, et mäppida ära sisse tulev JSON sõnum selleks Java CustomerDto tüüpi objektiks
    // Swaggeri'is on olemas ka request body näidis sellisest JSON'ist, mille Spring peaks suutma ära mäppida:
    //    {
    //        "id": 0,
    //        "firstName": "Otto",
    //        "lastName": "Triin",
    //        "isikukood": "123456789111"
    //    }
    // Kui @RequestBody teema on veel endiselt segane, siis palun vaata uuesti "Spring @RequestBody":
    // https://youtu.be/mIYDl4pf1P0
    // @Valid - annotatsioon kontrollib, et kas sissetulev JSON sõnum vastab sellistele nõuetele,
    // nagu on CustomerDto klassis muutujate peal defineeritud.
    @PostMapping
    @Operation(summary = "Lisab uue kliendi.")
    public CustomerDto addNewCustomer(@Valid @RequestBody CustomerDto customerDto) {
        // Võtame addNewCustomer() signatuuri @RequestBody parameetris sisse CustomerDto tüüpi objekti
        // Siin signatuuris antakse sellele objektile/muutujale nimeks 'customerDto'

        // Kutsume välja meie poolt defineeritud meetodi customerService.addNewCustomer()
        // See meetod on meil ära defineeritud CustomerService klassis
        // customerService.addNewCustomer() on meil selliselt defineeritud, et see võtab sisse parameetritena: CustomerDto tüüpi objekti
        // See on selleks vajalik, et me saaksime anda meetodisse kaasa anda objektid, kus sees on mingid andmed,
        // millega me soovime kuidagi toimetada.
        // customerService.addNewCustomer() meetod on defineeritud nii, et see tagastab CustomerDto tüüpi objekti
        // RETURN'iga tagastatakse serverist selle customerService.addNewCustomer() saadud tulemus JSON kujul.
        // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
        // https://youtu.be/EI3XfkdPBc4
        // https://youtu.be/GvP68LBZiUA
        // https://youtu.be/4ZkvNfu9kNw
        // vaata ka kommentaare selle 'customerService.addNewCustomer()' meetodi sees
        return customerService.addNewCustomer(customerDto);
    }

    // Kui meie veebiserverisse tuleb sisse http päring 'GET' 'http://localhost:8080/customer/all'
    // siis käivitatakse selle mäppingu all olev meetod getAllCustomers()
    // Kui @GetMapping teema on veel endiselt segane, siis palun vaata uuesti "Spring HelloWorld":
    // https://youtu.be/pc9irBCk6rg
    @GetMapping("/all")
    @Operation(summary = "Tagastab kõik kliendid.")
    public List<CustomerDto> getAllCustomers() {

        // Kuna getAllCustomers() meetod, on defineeritud nii, et see tagastab List<CustomerDto> tüüpi objekti,
        // siis return'is peab olema List<CustomerDto> tüüpi objekt
        // Spring teeb tagastades sellest Java objektist JSON objekti.
        // Kui see JSON teema on veel endiselt segane, siis palun vaata uuesti:
        // https://youtu.be/dyZUWR3Cchw
        // http päringule tagastatakse List<CustomerDto> objekt JSON'i kujul
        // Swaggeris on iga kontrolleri all ka response JSON näidis

        // siin returnis tagastatake selle customerService.getAllCustomers() meetodi poolt tagastatav tulemus.
        // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
        // https://youtu.be/EI3XfkdPBc4
        // https://youtu.be/GvP68LBZiUA
        // https://youtu.be/4ZkvNfu9kNw
        // vaata ka kommentaare selle 'customerService.getAllCustomers()' meetodi sees
        return customerService.getAllCustomers();
    }

    // Kui meie veebiserverisse tuleb sisse http päring 'GET' 'http://localhost:8080/customerall?id=1'
    // sellisel juhul oleks RequestParam lastName sisendiks '1'
    // siis käivitatakse selle mäppingu all olev meetod findCustomerById()
    // Kuna findCustomerById meetod, on defineeritud nii, et see tagastab CustomerDto tüüpi objekti,
    // siis return'is peab olema CustomerDto tüüpi objekt
    // Kuna meetodi parameetris on ära defineeritud @RequestParam Integer tüüpi objekt,
    // siis Spring eeldab, et http sõnumile antakse kaasa request parameeter 'id'
    // Kindlasti peab meetodi signatuuris olema ka see @RequestParam annotatsioon, sest muidu Spring ei tea,
    // et siia enpoint'ile peaks ka sisse tulema selline parameeter
    // Kui @RequestParam teema on veel endiselt segane, siis palun vaata uuesti "Spring @RequestParam":
    // https://youtu.be/9ovmRakMRBY
    @GetMapping("/id")
    @Operation(summary = "Leiab andmebaasi id järgi kliendi.")
    public CustomerDto findCustomerById(@RequestParam Integer id) {
        // Võtame findCustomerById() signatuuri request parameetris sisse Integer tüüpi objekti
        // Siin signatuuris antakse sellele objektile/muutujale nimeks 'id'

        // Kutsume välja meie poolt defineeritud meetodi customerService.findCustomerById()
        // See meetod on meil ära defineeritud CustomerService klassis
        // customerService.findCustomerById() on meil selliselt defineeritud, et see võtab sisse parameetritena: Integer tüüpi objekti
        // See on selleks vajalik, et me saaksime anda meetodisse kaasa anda objektid, kus sees on mingid andmed,
        // millega me soovime kuidagi toimetada.
        // findCustomerById() meetod on defineeritud nii, et see tagastab CustomerDto tüüpi objekti
        // returniga tagastatakse serverist selle customerService.findCustomerById() saadud tulemus.
        // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodite loomine" ja "Public ja Private meetodid":
        // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
        // https://youtu.be/EI3XfkdPBc4
        // https://youtu.be/GvP68LBZiUA
        // https://youtu.be/4ZkvNfu9kNw
        // vaata ka kommentaare selle 'customerService.getAllCustomers()' meetodi sees
        return customerService.findCustomerById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Kustutab andmebaasi id järgi kliendi.")
    public void removeCustomerById(@RequestParam Integer id) {
        customerService.removeCustomerById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Uuendab andmebaasi id järgi klienti.")
    public void updateCustomerById(@RequestParam Integer id, @Valid @RequestBody CustomerDto customerDto) {
        customerService.updateCustomerById(id, customerDto);
    }

}

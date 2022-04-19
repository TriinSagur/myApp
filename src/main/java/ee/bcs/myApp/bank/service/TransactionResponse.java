package ee.bcs.myApp.bank.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //konstruktor, mis sisaldab kõiki välju
@NoArgsConstructor // tühi konstruktor
public class TransactionResponse {
    private Integer referenceNumber;


}

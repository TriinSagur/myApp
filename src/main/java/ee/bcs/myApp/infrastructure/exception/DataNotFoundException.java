package ee.bcs.myApp.infrastructure.exception;

import lombok.Data;

// Enda loodud klass, millega oma väljamõeldud vigu saaks visata.
// See enda loodud 'DataNotFoundException' klass laiendab RuntimeException klassi
// Sellega saadakse RuntimeException klassi omadused
// RestExceptionHandler klassis on meil tehtud seadistus, et püüda kinni selline viga
@Data
public class DataNotFoundException extends RuntimeException {
    private final String title;
    private final  String detail;

    public DataNotFoundException(String title, String detail) {
        super(title);
        this.title = title;
        this.detail = detail;
    }
}

package ee.bcs.myApp.infrastructure.error;

import lombok.Data;

// Enda loodud Dto klass, millega error sõnumite andmeid edastada
@Data
public class ApiError {
    private String title;
    private Integer statusCode;
    private String detail;
}


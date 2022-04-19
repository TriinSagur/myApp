package ee.bcs.myApp.infrastructure.exception;

import lombok.Data;

@Data
public class BusinessExeption extends RuntimeException {
    private final String title;
    private final  String detail;

    public BusinessExeption(String title, String detail) {
        super(title);
        this.title = title;
        this.detail = detail;
    }
}

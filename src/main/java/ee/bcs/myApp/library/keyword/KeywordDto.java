package ee.bcs.myApp.library.keyword;

import lombok.Data;

import java.io.Serializable;

@Data
public class KeywordDto implements Serializable {
    private final Integer id;
    private final String name;
}

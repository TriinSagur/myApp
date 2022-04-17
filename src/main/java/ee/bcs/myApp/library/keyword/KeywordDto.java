package ee.bcs.myApp.library.keyword;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class KeywordDto implements Serializable {
    private Integer id;
    @NotNull
    private String name;
}

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountTransaction {

    @JsonProperty(required = true)
    private BigDecimal amount;

    @JsonProperty(required = true)
    private String fromAccountId;

    @JsonProperty(required = true)
    private String toAccountId;

}

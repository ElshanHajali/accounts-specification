package az.company.accounts.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsCriteriaRequest {

    private BigDecimal balanceFrom;
    private BigDecimal balanceTo;
    private String branchAddress;

}

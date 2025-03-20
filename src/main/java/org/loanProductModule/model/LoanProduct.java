package org.loanProductModule.model;
import lombok.Data;

@Data
public class LoanProduct {
    private Integer loanProductId;
    private String productName;
    private Double interestRate;
    private Double minAmount;
    private Double maxAmount;
    private Integer tenure; // in months
}

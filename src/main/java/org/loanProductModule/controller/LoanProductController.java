package org.loanProductModule.controller;

import org.loanProductModule.exception.LoanProductNotFoundException;
import org.loanProductModule.model.LoanProduct;
import org.loanProductModule.service.LoanProductService;

import java.util.List;

public class LoanProductController {

    private final LoanProductService loanProductService;

    public LoanProductController(LoanProductService loanProductService) {
        this.loanProductService = loanProductService;
    }

    public LoanProduct addLoanProduct(LoanProduct loanProduct) {
        return loanProductService.addLoanProduct(loanProduct);
    }

    public LoanProduct updateLoanProduct(LoanProduct loanProduct) {
        try {
            return loanProductService.updateLoanProduct(loanProduct);
        } catch (LoanProductNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public LoanProduct getLoanProductDetails(Integer loanProductId) {
        try {
            return loanProductService.getLoanProductDetails(loanProductId);
        } catch (LoanProductNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public List<LoanProduct> getAllLoanProducts() {
        return loanProductService.getAllLoanProducts();
    }
}
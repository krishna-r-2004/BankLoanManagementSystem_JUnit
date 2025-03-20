package org.loanProductModule.service;

import org.loanProductModule.exception.LoanProductNotFoundException;
import org.loanProductModule.model.LoanProduct;

import java.util.List;

public interface LoanProductService {
    LoanProduct addLoanProduct(LoanProduct loanProduct);
    LoanProduct updateLoanProduct(LoanProduct loanProduct) throws LoanProductNotFoundException;
    LoanProduct getLoanProductDetails(Integer loanProductId) throws LoanProductNotFoundException;
    List<LoanProduct> getAllLoanProducts();
}
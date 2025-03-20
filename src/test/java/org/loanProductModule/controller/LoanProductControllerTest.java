package org.loanProductModule.controller;
import org.loanProductModule.service.LoanProductService;
import org.loanProductModule.exception.LoanProductNotFoundException;
import org.loanProductModule.model.LoanProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.*;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoanProductControllerTest {

    @Mock
    private LoanProductService loanProductService;

    @InjectMocks
    private LoanProductController loanProductController;

    private LoanProduct loanProduct;

    @BeforeEach
    public void setUp() {
            MockitoAnnotations.openMocks(this);
            loanProduct = new LoanProduct();
            loanProduct.setLoanProductId(1);
            loanProduct.setProductName("Home Loan");
            loanProduct.setInterestRate(5.5);
            loanProduct.setMinAmount(100000.0);
            loanProduct.setMaxAmount(5000000.0);
            loanProduct.setTenure(12);

    }

    @Test
    void addLoanProduct() {
        when(loanProductService.addLoanProduct(any(LoanProduct.class))).thenReturn(loanProduct);
        LoanProduct result = loanProductController.addLoanProduct(loanProduct);
        assertNotNull(result);
        assertEquals(loanProduct.getLoanProductId(), result.getLoanProductId());
    }

    @Test
    void updateLoanProduct() {
        try {
            when(loanProductService.updateLoanProduct(any(LoanProduct.class))).thenReturn(loanProduct);
            LoanProduct result = loanProductController.updateLoanProduct(loanProduct);
            assertNotNull(result);
            assertEquals("Home Loan", result.getProductName());
        } catch (LoanProductNotFoundException e) {
            fail("Loan product cannot found and updated!");
        }
    }

    @Test
    void getLoanProductDetails() {
        try {
            when(loanProductService.getLoanProductDetails(anyInt())).thenReturn(loanProduct);
            LoanProduct result = loanProductController.getLoanProductDetails(1);
            assertNotNull(result);
            assertEquals(loanProduct.getLoanProductId(), result.getLoanProductId());
        } catch (LoanProductNotFoundException e) {
            fail("Loan product details not found");
        }
    }

    @Test
    void getAllLoanProducts() {
        List<LoanProduct> loanProducts = Arrays.asList(loanProduct);
        when(loanProductService.getAllLoanProducts()).thenReturn(loanProducts);
        List<LoanProduct> result = loanProductController.getAllLoanProducts();
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void testLoanProductParametersNotNull() {
        assertTrue(loanProduct.getLoanProductId() != null, "Loan Product ID should not be null");
        assertTrue(loanProduct.getInterestRate() != null, "Interest Rate should not be null");
        assertTrue(loanProduct.getMinAmount() != null, "Minimum Amount should not be null");
        assertTrue(loanProduct.getMaxAmount() != null, "Maximum Amount should not be null");
        assertTrue(loanProduct.getTenure() != null, "Tenure should not be null");
    }


    @Test
    void testLoanProductNameNotEmpty() {
        assertTrue(!loanProduct.getProductName().isEmpty(), "Product Name should not be empty");
    }
}

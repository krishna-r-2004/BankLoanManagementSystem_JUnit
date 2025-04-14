#Project: Bank Loan Management System

##Overview
The Bank Loan Management System is a web-based application that streamlines the process of loan 
application, approval, disbursement, and repayment tracking. The system is designed for banking 
institutions to handle various types of loans such as personal loans, home loans, and vehicle loans.

##Loan Product Management
This module is designed for managing loan products offered by the bank, such as personal loans, 
home loans, and vehicle loans. It includes details like interest rates, tenures, and eligible 
amounts

Loan Product Management Module
Purpose: Allows administrators to create and manage loan product details.
• Controller:
o LoanProductController
▪ addLoanProduct()
▪ updateLoanProduct()
▪ getLoanProductDetails()
• Service:
o LoanProductService
▪ Implements logic for managing loan types and terms.
• Model:
o LoanProduct Entity
▪ Attributes:
▪ loanProductId (PK)
▪ productName
▪ interestRate
▪ minAmount
▪ maxAmount
▪ tenure (in months)
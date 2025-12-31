/**
 * Program Name: JFLoanPayable.java
 * Purpose: 	 To define a contract for calculating loan payments, including methods for converting 
 * 				 annual interest rates to monthly rates and calculating loan payments based on loan amount, 
 * 				 annual interest rate, and amortization period in months.
 * @author: 	 Omar Alkhamissi
 * Date: 		 Mar 25, 2024
 */
public interface JSLoanPayable {
    double ANNUAL_RATE_TO_MONTHLY_RATE = 1.0 / 1200.0;

    double calculateLoanPayment(double loanAmount, double annualInterestRate, int amortizationPeriodMonths);
}

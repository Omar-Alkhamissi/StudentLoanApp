public interface JSLoanPayable {
    double ANNUAL_RATE_TO_MONTHLY_RATE = 1.0 / 1200.0;

    double calculateLoanPayment(double loanAmount, double annualInterestRate, int amortizationPeriodMonths);
}

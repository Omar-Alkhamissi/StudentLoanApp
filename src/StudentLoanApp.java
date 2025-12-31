/**
 * Program Name: StudentLoanApp.java
 * Purpose:		 To create a graphical user interface for a student loan application, 
 * 				 allowing users to input student information and calculate loan payments.  		
 * @author: 	 Omar Alkhamissi
 * Date:		 Feb 25, 2024
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class StudentLoanApp extends JFrame implements JSLoanPayable {
    private ArrayList<Student> students;
    private int currentStudentIndex;

    private JLabel titleLabel,studentInfoLabel, cslPaymentLabel, oslPaymentLabel, totalPaymentLabel,
    			   totalInterestLabel, totalAmountLabel;
    
    private JTextField studentIDField,surnameField, middleNameField, firstNameField, aptNumberField,
    				   streetNumberField, streetNameField, cityField, provinceField, postalCodeField,
    				   cslLoanAmountField, oslLoanAmountField, amortizationPeriodField;
   
    private JButton submitButton, clearButton, prevStudentButton, nextStudentButton, calculateButton;

    private JPanel paymentPanel;
  
    private JComboBox<String> interestRateComboBox;

 

    /**
     * This class represents a student loan application.
     * It provides a user interface for entering student information and calculating loan payments.
     */
    public StudentLoanApp(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        students = new ArrayList<>();
        currentStudentIndex = 0;

        titleLabel = new JLabel("This is Omar Alkhamissi's Student Loan Calculator");
        add(titleLabel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        add(mainPanel, BorderLayout.CENTER);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(12, 1, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Student Information"));

        JPanel studentIDContainer = new JPanel(new GridLayout(1, 2, 5, 5));
        studentIDContainer.add(new JLabel("Student ID:"));
        studentIDField = new JTextField();
        studentIDField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        studentIDContainer.add(studentIDField);
        inputPanel.add(studentIDContainer);

        JPanel nameContainer = new JPanel(new GridLayout(1, 3, 5, 5));
        nameContainer.add(new JLabel("Surname:"));
        surnameField = new JTextField();
        nameContainer.add(surnameField);
        nameContainer.add(new JLabel("Middle Name:"));
        middleNameField = new JTextField();
        nameContainer.add(middleNameField);
        nameContainer.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        nameContainer.add(firstNameField);
        inputPanel.add(nameContainer);

        JPanel addressContainer = new JPanel(new GridLayout(1, 3, 5, 5));
        addressContainer.add(new JLabel("Apt Number:"));
        aptNumberField = new JTextField();
        addressContainer.add(aptNumberField);
        addressContainer.add(new JLabel("Street Number:"));
        streetNumberField = new JTextField();
        addressContainer.add(streetNumberField);
        addressContainer.add(new JLabel("Street Name:"));
        streetNameField = new JTextField();
        addressContainer.add(streetNameField);
        inputPanel.add(addressContainer);

        JPanel cityContainer = new JPanel(new GridLayout(1, 3, 5, 5));
        cityContainer.add(new JLabel("City:"));
        cityField = new JTextField();
        cityContainer.add(cityField);
        cityContainer.add(new JLabel("Province:"));
        provinceField = new JTextField();
        cityContainer.add(provinceField);
        cityContainer.add(new JLabel("Postal Code:"));
        postalCodeField = new JTextField();
        cityContainer.add(postalCodeField);
        inputPanel.add(cityContainer);

        JPanel loanAmountContainer = new JPanel(new GridLayout(1, 2, 5, 5));
        loanAmountContainer.add(new JLabel("CSL Loan Amount:"));
        cslLoanAmountField = new JTextField();
        loanAmountContainer.add(cslLoanAmountField);
        loanAmountContainer.add(new JLabel("OSL Loan Amount:"));
        oslLoanAmountField = new JTextField();
        loanAmountContainer.add(oslLoanAmountField);
        inputPanel.add(loanAmountContainer);

        JPanel inputButtonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());
        inputButtonPanel.add(submitButton);
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ClearButtonListener());
        inputButtonPanel.add(clearButton);
        inputPanel.add(inputButtonPanel);

        mainPanel.add(inputPanel);

        // Payment Panel
        paymentPanel = new JPanel(new GridLayout(10, 2, 5, 5));
        paymentPanel.setBorder(BorderFactory.createTitledBorder("Loan Payment Calculation"));

        studentInfoLabel = new JLabel();
        paymentPanel.add(studentInfoLabel);
        paymentPanel.add(new JLabel());

        paymentPanel.add(new JLabel("Interest Rate:"));
        interestRateComboBox = new JComboBox<>();
        for (double rate = 0.0; rate <= 10.0; rate += 0.25) {
            interestRateComboBox.addItem(String.format("%.2f%%", rate));
        }
        paymentPanel.add(interestRateComboBox);

        paymentPanel.add(new JLabel("Amortization Period (months):"));
        amortizationPeriodField = new JTextField();
        amortizationPeriodField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        paymentPanel.add(amortizationPeriodField);
        
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        calculateButton.setEnabled(false);
        paymentPanel.add(calculateButton);
        paymentPanel.add(new JLabel());

        paymentPanel.add(new JLabel("CSL Monthly Payment:"));
        cslPaymentLabel = new JLabel();
        paymentPanel.add(cslPaymentLabel);

        paymentPanel.add(new JLabel("OSL Monthly Payment:"));
        oslPaymentLabel = new JLabel();
        paymentPanel.add(oslPaymentLabel);

        paymentPanel.add(new JLabel("Total Monthly Payment:"));
        totalPaymentLabel = new JLabel();
        paymentPanel.add(totalPaymentLabel);

        paymentPanel.add(new JLabel("Total Interest Paid:"));
        totalInterestLabel = new JLabel();
        paymentPanel.add(totalInterestLabel);

        paymentPanel.add(new JLabel("Total Amount Paid:"));
        totalAmountLabel = new JLabel();
        paymentPanel.add(totalAmountLabel);

        JPanel paymentButtonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        prevStudentButton = new JButton("Previous Student");
        prevStudentButton.addActionListener(new PrevStudentButtonListener());
        paymentButtonPanel.add(prevStudentButton);

        nextStudentButton = new JButton("Next Student");
        nextStudentButton.addActionListener(new NextStudentButtonListener());
        paymentButtonPanel.add(nextStudentButton);

        prevStudentButton.setEnabled(false);
        nextStudentButton.setEnabled(false);

        paymentPanel.add(paymentButtonPanel);
        mainPanel.add(paymentPanel);

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * This class represents a listener for the Submit button.
     * It validates the input fields and creates a new student object.
     */
    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String studentID = studentIDField.getText();

                if (studentID.length() != 7) {
                    throw new JSNegativeValueException("Student ID must be 7 digits.");
                }

                String surname = surnameField.getText();
                String middleName = middleNameField.getText();
                String firstName = firstNameField.getText();
                String aptNumber = aptNumberField.getText();
                String streetNumber = streetNumberField.getText();
                String streetName = streetNameField.getText();
                String city = cityField.getText();
                String province = provinceField.getText();
                String postalCode = postalCodeField.getText();
                double cslLoanAmount = Double.parseDouble(cslLoanAmountField.getText());
                double oslLoanAmount = Double.parseDouble(oslLoanAmountField.getText());

                Student student = new Student(studentID, surname, middleName, firstName, aptNumber, streetNumber, streetName, city, province, postalCode, cslLoanAmount, oslLoanAmount);
                students.add(student);
                currentStudentIndex = students.size() - 1;
                prevStudentButton.setEnabled(currentStudentIndex > 0);
                nextStudentButton.setEnabled(currentStudentIndex < students.size() - 1);
                calculateButton.setEnabled(!students.isEmpty());
                updateStudentInfo();
                clearFields();

            } catch (JSNegativeValueException ex) {
                JOptionPane.showMessageDialog(StudentLoanApp.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

        }
    }

    /**
     * This class represents a listener for the Clear button.
     * It clears the input fields.
     */
    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clearFields();
        }
    }

    /**
     * This class represents a listener for the Calculate button.
     * It calculates the monthly loan payments based on the input values.
     */
    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Student student = students.get(currentStudentIndex);

            double cslLoanAmount = student.getCslLoanAmount();
            double oslLoanAmount = student.getOslLoanAmount();

            try {
                if (cslLoanAmount <= 0 || oslLoanAmount <= 0) {
                    throw new JSNegativeValueException("Loan amounts must be greater than 0.");
                }
            } catch (JSNegativeValueException ex) {
                JOptionPane.showMessageDialog(StudentLoanApp.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double annualInterestRate = Double.parseDouble(interestRateComboBox.getSelectedItem().toString().replace("%", ""));
            if (annualInterestRate < 0 || annualInterestRate > 10) {
                JOptionPane.showMessageDialog(null, "Interest rate must be between 0% and 10%.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                if (amortizationPeriodField.getText().isEmpty()) {
                    throw new JSNegativeValueException("Amortization period is required.");
                }
                int amortizationPeriodMonths = Integer.parseInt(amortizationPeriodField.getText());
                if (amortizationPeriodMonths <= 0 ) {
                    throw new JSNegativeValueException("Amortization period must be greater than 0.");
                }

                double cslPayment = calculateLoanPayment(cslLoanAmount, annualInterestRate + 2.5, amortizationPeriodMonths);
                double oslPayment = calculateLoanPayment(oslLoanAmount, annualInterestRate + 1.0, amortizationPeriodMonths);

                double totalPayment = cslPayment + oslPayment;
                double totalInterest = (cslPayment * amortizationPeriodMonths) - cslLoanAmount + (oslPayment * amortizationPeriodMonths) - oslLoanAmount;
                double totalAmount = totalPayment * amortizationPeriodMonths;

                cslPaymentLabel.setText(String.format("$%.2f", cslPayment));
                oslPaymentLabel.setText(String.format("$%.2f", oslPayment));
                totalPaymentLabel.setText(String.format("$%.2f", totalPayment));
                totalInterestLabel.setText(String.format("$%.2f", totalInterest));
                totalAmountLabel.setText(String.format("$%.2f", totalAmount));

            } catch (JSNegativeValueException ex) {
                JOptionPane.showMessageDialog(StudentLoanApp.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }

    /**
     * This class represents a listener for the Previous Student button.
     * It decrements the current student index and updates the student information displayed in the UI.
     */
    private class PrevStudentButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentStudentIndex > 0) {
                currentStudentIndex--;
                updateStudentInfo();
            }
            prevStudentButton.setEnabled(currentStudentIndex > 0);
            nextStudentButton.setEnabled(currentStudentIndex < students.size() - 1);
        }
    }

    /**
     * This class represents a listener for the Next Student button.
     * It increments the current student index and updates the student information displayed in the UI.
     */
    private class NextStudentButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentStudentIndex < students.size() - 1) {
                currentStudentIndex++;
                updateStudentInfo();
            }
            prevStudentButton.setEnabled(currentStudentIndex > 0);
            nextStudentButton.setEnabled(currentStudentIndex < students.size() - 1);
        }
    }

    /**
     * This method clears the input fields.
     */
    private void clearFields() {
        studentIDField.setText("");
        surnameField.setText("");
        middleNameField.setText("");
        firstNameField.setText("");
        aptNumberField.setText("");
        streetNumberField.setText("");
        streetNameField.setText("");
        cityField.setText("");
        provinceField.setText("");
        postalCodeField.setText("");
        cslLoanAmountField.setText("");
        oslLoanAmountField.setText("");
    }

    /**
     * This method updates the student information displayed in the UI.
     * It also clears the payment information.
     */
    private void updateStudentInfo() {
        Student student = students.get(currentStudentIndex);
        studentInfoLabel.setText(student.toString());
        cslPaymentLabel.setText("");
        oslPaymentLabel.setText("");
        totalPaymentLabel.setText("");
        totalInterestLabel.setText("");
        totalAmountLabel.setText("");
    }

    /**
     * This method calculates the monthly loan payment.
     * @param loanAmount The amount of the loan.
     * @param annualInterestRate The annual interest rate.
     * @param amortizationPeriodMonths The amortization period in months.
     * @return The monthly loan payment.
     */
    @Override
    public double calculateLoanPayment(double loanAmount, double annualInterestRate, int amortizationPeriodMonths) {
        double monthlyInterestRate = (annualInterestRate * ANNUAL_RATE_TO_MONTHLY_RATE) / 100;
        double numerator = loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, amortizationPeriodMonths);
        double denominator = Math.pow(1 + monthlyInterestRate, amortizationPeriodMonths) - 1;
        return numerator / denominator;
    }

    /**
     * This method is the entry point for the application.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentLoanApp app = new StudentLoanApp("Omar Alkhamissi - Student Loan Calculator");
            app.setVisible(true);
        });
    }
}

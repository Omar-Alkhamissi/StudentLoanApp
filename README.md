# StudentLoanApp

StudentLoanApp is a Java Swing application for entering student-loan applicant details and calculating loan repayment amounts.

## Features

- Form-based applicant and address capture
- Canada/Ontario student loan amount inputs
- Interest-rate selection and amortization period entry
- Monthly payment, total interest, and total amount calculations
- Previous/next navigation through entered applicants

## Tech Stack

- Java
- Swing/AWT
- Eclipse project metadata

## Getting Started

Import the project into Eclipse or compile from the command line:

```bash
javac src/*.java
java -cp src StudentLoanApp
```

## Project Structure

- `src/StudentLoanApp.java`: GUI and event handling
- `src/Student.java`: applicant data model
- `src/JSLoanPayable.java`: payment calculation contract
- `src/JSNegativeValueException.java`: validation exception

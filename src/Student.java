/**
 * Program Name: Student.java
 * Purpose: 	 To define a Student class that encapsulates the details of a student, 
 * 				 including personal information and loan amounts, providing a model for storing 
 * 				 and manipulating student data.  	 
 * @author 		 Omar Alkhamissi
 * Date: 		 Feb 25, 2024
 */

public class Student {
    private final String studentID;
    private String surname;
    private String middleName;
    private String firstName;
    private String aptNumber;
    private String streetNumber;
    private String streetName;
    private String city;
    private String province;
    private String postalCode;
    private double cslLoanAmount;
    private double oslLoanAmount;

    /**
     * This class represents a student.
     * It stores information about the student and their loan amounts.
     */
    public Student(String studentID, String surname, String middleName, String firstName, String aptNumber, String streetNumber, String streetName, String city, String province, String postalCode, double cslLoanAmount, double oslLoanAmount) {
        this.studentID = studentID;
        this.surname = surname;
        this.middleName = middleName;
        this.firstName = firstName;
        this.aptNumber = aptNumber;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.cslLoanAmount = cslLoanAmount;
        this.oslLoanAmount = oslLoanAmount;
    }

    /**
     * This method returns the student's ID.
     * @return The student's ID.
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * This method returns the student's surname.
     * @return The student's surname.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * This method returns the student's middle name.
     * @return The student's middle name.
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * This method returns the student's first name.
     * @return The student's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method returns the student's apartment number.
     * @return The student's apartment number.
     */
    public String getAptNumber() {
        return aptNumber;
    }

    /**
     * This method returns the student's street number.
     * @return The student's street number.
     */
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * This method returns the student's street name.
     * @return The student's street name.
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * This method returns the student's city.
     * @return The student's city.
     */
    public String getCity() {
        return city;
    }

    /**
     * This method returns the student's province.
     * @return The student's province.
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method returns the student's postal code.
     * @return The student's postal code.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * This method returns the student's CSL loan amount.
     * @return The student's CSL loan amount.
     */
    public double getCslLoanAmount() {
        return cslLoanAmount;
    }

    /**
     * This method returns the student's OSL loan amount.
     * @return The student's OSL loan amount.
     */
    public double getOslLoanAmount() {
        return oslLoanAmount;
    }

    /**
     * This method sets the student's surname.
     * @param surname The student's surname.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * This method sets the student's middle name.
     * @param middleName The student's middle name.
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * This method sets the student's first name.
     * @param firstName The student's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This method sets the student's apartment number.
     * @param aptNumber The student's apartment number.
     */
    public void setAptNumber(String aptNumber) {
        this.aptNumber = aptNumber;
    }

    /**
     * This method sets the student's street number.
     * @param streetNumber The student's street number.
     */
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * This method sets the student's street name.
     * @param streetName The student's street name.
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * This method sets the student's city.
     * @param city The student's city.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This method sets the student's province.
     * @param province The student's province.
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * This method sets the student's postal code.
     * @param postalCode The student's postal code.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * This method sets the student's CSL loan amount.
     * @param cslLoanAmount The student's CSL loan amount.
     */
    public void setCslLoanAmount(double cslLoanAmount) {
        this.cslLoanAmount = cslLoanAmount;
    }

    /**
     * This method sets the student's OSL loan amount.
     * @param oslLoanAmount The student's OSL loan amount.
     */
    public void setOslLoanAmount(double oslLoanAmount) {
        this.oslLoanAmount = oslLoanAmount;
    }

    /**
     * This method returns a string representation of the student.
     * @return A string representation of the student.
     */
    @Override
    public String toString() {
        return "Student Name: " + surname + ", " + firstName + " " + middleName + "\n" +
                "Student Number: " + studentID + "\n" +
                "CSL Amount is $" + String.format("%.2f", cslLoanAmount) + "\n" +
                "OSL Amount is $" + String.format("%.2f", oslLoanAmount);
    }
}


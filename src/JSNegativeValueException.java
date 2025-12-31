/**
 * Program Name: JSNegativeValueException
 * Purpose:		 To define a custom exception class for handling cases where a negative value is encountered 
 * 				 where it is not expected or allowed.
 * @author: 	 Omar Alkhamissi
 * Date:	     Mar 25, 2024
 */
public class JSNegativeValueException extends Exception {
    public JSNegativeValueException(String message) {
        super(message);
    }
}

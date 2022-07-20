package tbc.java.homework21;

/**
 * ValidateException is subclass of Exception
 * @author diana
 * @version 1.0.0
 *
 */
public class ValidateException extends Exception {
	String message;
	/**
	 * Creates instance of ValidateException class using received value;
	 * @param str
	 */
	ValidateException (String str){
		message = str;
	}
	
	@Override
	public String getMessage() {
		return message;
		
	}
}
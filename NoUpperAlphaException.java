/**
 * No upper alpha exception extends Exception
 * @author Sungmin Kim
 * @date 2021/02/12
 */
public class NoUpperAlphaException extends Exception {

	/**
	 * Constructor
	 */
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}

	/**
	 * Constructor take string message as a parameter
	 * @param message
	 */
	public NoUpperAlphaException(String message) {
		super(message);
	}

}

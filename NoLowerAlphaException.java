/**
 * No lower Alpha exception extends Exception
 * @author Sungmin Kim
 * @date 2021/02/12
 */
public class NoLowerAlphaException extends Exception {

	/**
	 * Constructor
	 */
	public NoLowerAlphaException() {
		super("The password must contain at least one lower case alphabetic character");
	}

	/**
	 * Constructor take string message as a parameter
	 * @param message
	 */
	public NoLowerAlphaException(String message) {
		super(message);
	}

}

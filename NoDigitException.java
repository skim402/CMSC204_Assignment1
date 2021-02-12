/**
 * No digit exception extends Exception
 * @author Sungmin Kim
 * @date 2021/02/12
 */
public class NoDigitException extends Exception {

	/**
	 * Constructor
	 */
	public NoDigitException() {
		super("The password must contain at least one digit");
	}

	/**
	 * Constructor take string message as a parameter
	 * @param message
	 */
	public NoDigitException(String message) {
		super(message);
	}

}

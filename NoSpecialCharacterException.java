/**
 * No special character exception extends Exception
 * @author Sungmin Kim
 * @date 2021/02/12
 */
public class NoSpecialCharacterException extends Exception {

	/**
	 * Constructor
	 */
	public NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}

	/**
	 * Constructor take string message as a parameter
	 * @param message
	 */
	public NoSpecialCharacterException(String message) {
		super(message);
	}

}

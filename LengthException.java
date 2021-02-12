/**
 * Length exception extends Exception
 * @author Sungmin Kim
 * @date 2021/02/12
 */
public class LengthException extends Exception {

	/**
	 * Constructor
	 */
	public LengthException() {
		super("The password must be at least 6 characters long");
	}

	/**
	 * Constructor take string message as a parameter
	 * @param message
	 */
	public LengthException(String message) {
		super(message);
	}
}

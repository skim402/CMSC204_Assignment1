/**
 * Invalid Sequence exception extends Exception
 * @author Sungmin Kim
 * @date 2021/02/12
 */
public class InvalidSequenceException extends Exception {

	/**
	 * Constructor
	 */
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence");
	}

	/**
	 * Constructor take string message as a parameter
	 * @param message
	 */
	public InvalidSequenceException(String message) {
		super(message);
	}
}

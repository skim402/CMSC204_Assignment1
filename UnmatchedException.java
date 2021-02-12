/**
 * Unmatched exception extends Exception
 * @author Sungmin Kim
 * @date 2021/02/12
 */
public class UnmatchedException extends Exception {

	/**
	 * Constructor
	 */
	public UnmatchedException() {
		super("The passwords do not match");
	}

	/**
	 * Constructor take string message as a parameter
	 * @param message
	 */
	public UnmatchedException(String message) {
		super(message);
	}
}

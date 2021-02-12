/**
 * Weak password exception extends Exception
 * @author Sungmin Kim
 * @date 2021/02/12
 */
public class WeakPasswordException extends Exception {

	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters");
	}

	public WeakPasswordException(String message) {
		super(message);
	}
}

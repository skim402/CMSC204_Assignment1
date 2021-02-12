import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * CMSC204 Assignment 1 - passwords check utility
 * @author Sungmin Kim
 * Professor: Sandro Fouche
 * Date: 2021/02/12
 */
public class PasswordCheckerUtility {
	
	/**
	 * Constructor
	 */
	public PasswordCheckerUtility() {

	}

	/**
	 * Compare two passwords if they equal
	 * @param password
	 * @param passwordConfirm
	 * @throws throw if the two passwords not matched (UnmatchedException)
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if (!password.equals(passwordConfirm))
			throw new UnmatchedException();
	}

	/**
	 * Compare two passwords if they equal with return
	 * @param password
	 * @param passwordConfirm
	 * @return if two password equal, return true, if not false
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		if (password.equals(passwordConfirm))
			return true;
		else
			return false;
	}

	/**
	 * Take ArrayList of passwords and save every invalid passwords and return
	 * @param passwords
	 * @return ArrayList of invalidpasswords
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		for (int i = 0; i < passwords.size(); i++) {
			try {
				isValidPassword(passwords.get(i));
			} catch (Exception e) {
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
			}
		}
		return invalidPasswords;
	}

	/**
	 * Check if a password has between six and nine characters
	 * @param password
	 * @return if the password has between six and nine characters return true, if not, false
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		if (password.length() > 5 && password.length() < 10)
			return true;
		else
			return false;
	}

	/**
	 * Check if a password has a digit
	 * @param password
	 * @return return true if the password has a digit
	 * @throws throw if the password does not have a digit (NoDigitException)
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) > 47 && password.charAt(i) < 58)
				return true;
		}
		throw new NoDigitException();
	}

	/**
	 * Check if a password has a lower case
	 * @param password
	 * @return return true if the password has a lower case
	 * @throws throw if the password does not have a lower case (NoLowerAlphaException)
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) > 96 && password.charAt(i) < 123)
				return true;
		}
		throw new NoLowerAlphaException();
	}

	/**
	 * Check if a password has three same characters in a row
	 * @param password
	 * @return return false if the password does not have three same characters in a row
	 * @throws throw if the password has three same characters in a row (InvalidSequenceException)
	 */
	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException {
		for (int i = 0; i < (password.length() - 2); i++) {
			if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) == password.charAt(i + 2))
				throw new InvalidSequenceException();
		}
		return false;
	}

	/**
	 * Check if a password has a special character
	 * @param password
	 * @return return true if the password has a special character
	 * @throws throw if the password does not have a special character (NoSpecialCharacterException)
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches())
			throw new NoSpecialCharacterException();
		else
			return true;
	}

	/**
	 * Check if a password has a upper case
	 * @param password
	 * @return return true if the password has a upper case
	 * @throws throw if the password does not have a upper case (NoUpperAlphaException)
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) > 64 && password.charAt(i) < 91)
				return true;
		}
		throw new NoUpperAlphaException();
	}

	/**
	 * Check if a password has at least 6 characters
	 * @param password
	 * @return return true if the password has at least 6 characters
	 * @throws throw if the password has less than 6 characters (LengthException)
	 */
	public static boolean isValidLength(String password) throws LengthException {
		if (password.length() < 6)
			throw new LengthException();
		else
			return true;
	}

	/**
	 * Check if a password is valid
	 * @param password
	 * @return return true if the password is valid
	 * @throws throw if the password has less than 6 characters (LengthException)
	 * @throws throw if the password does not have a upper case (NoUpperAlphaException)
	 * @throws throw if the password does not have a lower case (NoLowerAlphaException)
	 * @throws throw if the password does not have a digit (NoDigitException)
	 * @throws throw if the password does not have a special character (NoSpecialCharacterException)
	 * @throws throw if the password has three same characters in a row (InvalidSequenceException)
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException,
			NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		isValidLength(password);
		hasUpperAlpha(password);
		hasLowerAlpha(password);
		hasDigit(password);
		hasSpecialChar(password);
		hasSameCharInSequence(password);
		return true;
	}

	/**
	 * Check if a password is valid and has less than 10 characters
	 * @param password
	 * @return return true if the password is valid and has less than 10 characters
	 * @throws thtrow if the password id valid and has more than or equal to 10 characters (WeakPasswordException)
	 * @throws throw if the password has less than 6 characters (LengthException)
	 * @throws throw if the password does not have a upper case (NoUpperAlphaException)
	 * @throws throw if the password does not have a lower case (NoLowerAlphaException)
	 * @throws throw if the password does not have a digit (NoDigitException)
	 * @throws throw if the password does not have a special character (NoSpecialCharacterException)
	 * @throws throw if the password has three same characters in a row (InvalidSequenceException)
	 */
	public static boolean isWeakPassword(String password)
			throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException,
			NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		if (hasBetweenSixAndNineChars(password) && isValidPassword(password))
			return true;
		else
			throw new WeakPasswordException();
	}

}

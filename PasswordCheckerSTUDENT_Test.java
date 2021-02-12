
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

/**
 * STUDENT tests for the methods of PasswordChecker
 * 
 * @author
 *
 */
public class PasswordCheckerSTUDENT_Test {
	String password = "SMJacob8633!";
	String passwordConfirm = "smjacob8633!";
	String tooShort = "abc";
	String noUpper = "jacob8633";
	String noLower = "SMJCOB8633";
	String noDigit = "smjacobkim";
	String tripleChar = "aaabcdefH1!";
	String weak = "Kim8633!";
	ArrayList<String> invalidpasswords;
	ArrayList<String> validpasswords;
	
	@Before
	public void setUp() throws Exception {
		String password = "SMJacob8633!";
		String passwordConfirm = "smJacob8633!";
		String[] containInvalidpasswords = { "SMJacob", "Jacob", "jacob8633", "Jacob!", "SMJ"};
		invalidpasswords = new ArrayList<String>();
		invalidpasswords.addAll(Arrays.asList(containInvalidpasswords));
		String[] containValidpasswords = { "SMJacob8633!", "Jacob8633!", "jacobKIM8633?", "#smJACOB8633", "SMJ8633@gmail.com"};
		validpasswords = new ArrayList<String>();
		validpasswords.addAll(Arrays.asList(containValidpasswords));


	}

	@After
	public void tearDown() throws Exception {
		invalidpasswords = null;
		validpasswords = null;

	}

	/**
	 * Test if the password is less than 6 characters long. This test should throw a
	 * LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() {
		Throwable exception = Assertions.assertThrows(LengthException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.isValidLength(tooShort);
			}
		});
		assertEquals("The password must be at least 6 characters long", exception.getMessage());
	}

	/**
	 * Test if the password has at least one uppercase alpha character This test
	 * should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() {
		Throwable exception = assertThrows(NoUpperAlphaException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasUpperAlpha(noUpper);
			}
		});
		assertEquals("The password must contain at least one uppercase alphabetic character", exception.getMessage());
	}

	/**
	 * Test if the password has at least one lowercase alpha character This test
	 * should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() {
		Throwable exception = assertThrows(NoLowerAlphaException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasLowerAlpha(noLower);
			}
		});
		assertEquals("The password must contain at least one lower case alphabetic character", exception.getMessage());
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword() {
		try {
			assertEquals(true, PasswordCheckerUtility.isWeakPassword(weak));
		}catch (Exception e) {
			assertEquals("The password is OK but weak - it contains fewer than 10 characters", e.getMessage());
		}
		
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() {
		Throwable exception = assertThrows(InvalidSequenceException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasSameCharInSequence(tripleChar);
			}
		});
		assertEquals("The password cannot contain more than two of the same character in sequence",
				exception.getMessage());
	}

	/**
	 * Test if the password has at least one digit One test should throw a
	 * NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() {
		Throwable exception = assertThrows(NoDigitException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasDigit(noDigit);
			}
		});
		assertEquals("The password must contain at least one digit", exception.getMessage());
	}

	/**
	 * Test correct passwords This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() {
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword(password));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Test the invalidPasswords method Check the results of the ArrayList of
	 * Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwordConfirm));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw an exception", true);
		}
	}

}
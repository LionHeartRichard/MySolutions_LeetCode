package arrayandstring;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ValidPalindrome {

	public boolean isPalindrome(String source) {
		char[] arr = source.toCharArray();
		int left = 0, right = arr.length - 1;
		while (left < right) {
			if (!isCorrectSymbol(arr[left])) {
				++left;
				continue;
			}
			if (!isCorrectSymbol(arr[right])) {
				--right;
				continue;
			}
			char chL = arr[left++];
			char chR = arr[right--];
			chL = chL <= 'Z' ? (char) (chL + 32) : chL;
			chR = chR <= 'Z' ? (char) (chR + 32) : chR;
			if (chL != chR)
				return false;
		}
		return true;
	}

	private boolean isUperCase(char ch) {
		if ('A' <= ch && ch <= 'Z')
			return true;
		return false;
	}

	private boolean isLowerCase(char ch) {
		if ('a' <= ch && ch <= 'z')
			return true;
		return false;
	}

	private boolean isDigits(char ch) {
		if ('0' <= ch && ch <= '9')
			return true;
		return false;
	}

	private boolean isCorrectSymbol(char ch) {
		if (isUperCase(ch) || isLowerCase(ch) || isDigits(ch)) {
			return true;
		}
		return false;
	}

	@Test
	public void case0() {
		String s = "2213122";

		assertTrue(isPalindrome(s));
	}

	@Test
	public void case1() {
		String s = "A man, a plan, a canal: Panama";

		assertTrue(isPalindrome(s));
	}

	@Test
	public void case2() {
		String s = "race a car";

		assertFalse(isPalindrome(s));
	}

	@Test
	public void case3() {
		String s = " ";

		assertTrue(isPalindrome(s));
	}

	@Test
	public void case4() {
		String s = "0P";

		assertFalse(isPalindrome(s));
	}
}

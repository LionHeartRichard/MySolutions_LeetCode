package arrayandstring;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ValidPalindrome {

	public boolean isPalindrome(String source) {
		// обрабатываем край случай
		if (source.length() == 1)
			return true;

		int lIdx = 0, rIdx = source.length() - 1;
		while (lIdx < rIdx) {
			char chLeft = source.charAt(lIdx);
			if (!isCorrectSymbol(chLeft)) {
				++lIdx;
				continue;
			}
			char chRight = source.charAt(rIdx);
			if (!isCorrectSymbol(chRight)) {
				--rIdx;
				continue;
			}
			chLeft = isUperCase(chLeft) ? (char) (chLeft + 32) : chLeft;
			chRight = isUperCase(chRight) ? (char) (chRight + 32) : chRight;
			if (chLeft != chRight)
				return false;
			++lIdx;
			--rIdx;
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

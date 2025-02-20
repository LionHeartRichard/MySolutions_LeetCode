package repeat.repeat;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		char[] arr = s.toCharArray();
		int left = 0, right = arr.length - 1;

		while (left < right) {
			char chL = arr[left];
			char chR = arr[right];
			if (!((chL >= 'a' && chL <= 'z') || (chL >= 'A' && chL <= 'Z') || (chL >= '0' && chL <= '9'))) {
				++left;
				continue;
			}
			if (!((chR >= 'a' && chR <= 'z') || (chR >= 'A' && chR <= 'Z') || (chR >= '0' && chR <= '9'))) {
				--right;
				continue;
			}
			chL = chL <= 'Z' ? (char) (chL + 32) : chL;
			chR = chR <= 'Z' ? (char) (chR + 32) : chR;
			if (chL != chR)
				return false;
			++left;
			--right;
		}
		return true;
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

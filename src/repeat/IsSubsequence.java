package repeat;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

/*
 * Даны две строки s и t, вернуть true, если s является подпоследовательностью t, 
 * или false в противном случае.
 * Подпоследовательность строки — это новая строка, которая образована из исходной строки путем удаления некоторых 
 * (может быть ни одного) символов без нарушения относительного положения оставшихся символов. 
 * (т. е. «ace» является подпоследовательностью «abcde», а «aec» — нет).
 */

public class IsSubsequence {

	public boolean isSubsequence(String s, String text) {
		if (s.length() == 0)
			return true;
		if (text.length() == 0)
			return false;
		if (s.length() > text.length())
			return false;
		char[] sub = s.toCharArray();
		int begin = 0, len = text.length();
		for (char ch : sub) {
			int idx = text.indexOf(ch, begin, len);
			if (idx == -1)
				return false;
			begin = idx + 1;
		}
		return true;
	}

	@Test
	public void case1() {
		String s = "abc", t = "ahbgdc";

		assertTrue(isSubsequence(s, t));
	}

	@Test
	public void case2() {
		String s = "axc", t = "ahbgdc";

		assertFalse(isSubsequence(s, t));
	}

	@Test
	public void case3() {
		String s = "aaaaaa";
		String t = "bbaaaa";

		assertFalse(isSubsequence(s, t));
	}
}

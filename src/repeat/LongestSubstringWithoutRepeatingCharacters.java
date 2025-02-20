package repeat;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Для заданной строки s найдите длину самой длинной подстроки
 * без повторяющихся символов.
 */

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		int[] mapper = new int[128];
		for (int i = 0; i < 128; ++i)
			mapper[i] = -1;

		int window = 0;
		char[] source = s.toCharArray();
		for (int i = 0, j = 0; i < source.length; ++i) {
			char ch = source[i];
			// в счетчик j добавляем значение сдвига + 1
			if (mapper[ch] >= j)
				j = mapper[ch] + 1;
			// в мапу добавляем на сколько мы сдвинулись
			mapper[ch] = i;
			window = Math.max(window, i - j + 1);
		}
		return window;
	}

	@Test
	public void case1() {
		String s = "abcabcbb";

		int expected = 3;
		int actual = lengthOfLongestSubstring(s);
		// Explanation: The answer is "abc", with the length of 3.

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		String s = "bbbbb";
		int expected = 1;
		int actual = lengthOfLongestSubstring(s);
		// Explanation: The answer is "b", with the length of 1.

		assertEquals(expected, actual);
	}

	@Test
	public void case3() {

		String s = "pwwkew";
		int expected = 3;
		int actual = lengthOfLongestSubstring(s);
		// Explanation: The answer is "wke", with the length of 3.

		assertEquals(expected, actual);
	}
}

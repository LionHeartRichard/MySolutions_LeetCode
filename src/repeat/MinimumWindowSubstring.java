package repeat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Даны две строки s и t длиной m и n соответственно, вернуть минимальное окно
 * подстроки s так, чтобы каждый символ в t (включая дубликаты) был включен в окно. 
 * Если такой подстроки нет, вернуть пустую строку "".
 * 
 * Тестовые случаи будут сгенерированы таким образом, чтобы ответ был уникальным.
 * 
 * s и t состоят из заглавных и строчных английских букв.
 */

public class MinimumWindowSubstring {

	public String minWindow(String s, String t) {
		if (s.length() < t.length())
			return "";

		char[] target = t.toCharArray();
		int[] cache = new int[128];
		int count = target.length;
		for (char ch : target) {
			++cache[ch];
		}

		char[] source = s.toCharArray();
		int len = source.length, slowIdx = 0, fastIdx = 0;
		int beginIdx = 0, window = len + 1;

		while (slowIdx < len) {
			int idx = source[slowIdx++];
			if (cache[idx] > 0)
				--count;
			--cache[idx];
			while (count == 0) {
				int innerIdx = source[fastIdx];
				int tmp = slowIdx - fastIdx;
				if (tmp < window) {
					beginIdx = fastIdx;
					window = tmp;
				}
				if (cache[innerIdx]++ == 0)
					++count;
				++fastIdx;
			}
		}

		return window == len + 1 ? "" : s.substring(beginIdx, beginIdx + window);
	}

	@Test
	public void case0() {
		String s = "AbsdJot", t = "Jt";

		String expected = "Jot";
		String actual = minWindow(s, t);

		assertEquals(expected, actual);
	}

	@Test
	public void case001() {
		String s = "JotAbsd", t = "Jt";

		String expected = "Jot";
		String actual = minWindow(s, t);

		assertEquals(expected, actual);
	}

	@Test
	public void case002() {
		String s = "JootAJtsd", t = "Jt";

		String expected = "Jt";
		String actual = minWindow(s, t);

		assertEquals(expected, actual);
	}

	@Test
	public void case003() {
		String s = "JootAJhsd", t = "Jt";

		String expected = "tAJ";
		String actual = minWindow(s, t);

		assertEquals(expected, actual);
	}

	@Test
	public void case115() {
		String s = "bdab", t = "ab";

		String expected = "ab";
		String actual = minWindow(s, t);

		assertEquals(expected, actual);
	}

	@Test
	public void case123() {
		String s = "bba", t = "ab";

		String expected = "ba";
		String actual = minWindow(s, t);

		assertEquals(expected, actual);
	}

	@Test
	public void case178() {
		String s = "acbbaca", t = "aba";

		String expected = "baca";
		String actual = minWindow(s, t);

		assertEquals(expected, actual);
	}
}

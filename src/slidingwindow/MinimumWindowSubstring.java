package slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
		char[] source = s.toCharArray(), target = t.toCharArray();

		// заполняем кэш 128 так как учитываем регистр и не заморачиваемся с индесами
		int[] cache = new int[128];
		for (char ch : target) {
			++cache[ch];
		}

		int fastIdx = 0, slowIdx = 0, len = source.length;
		int beginIdx = 0, window = len + 1, count = target.length;

		// расчитываем окно исходя количества символов кэша
		// используем паттерн медленный и быстрый указатель
		while (slowIdx < len) {
			if (cache[source[slowIdx]] > 0) {
				--count;
			}
			--cache[source[slowIdx++]];
			while (count == 0) {
				if (slowIdx - fastIdx < window) {
					window = slowIdx - fastIdx;
					beginIdx = fastIdx;
				}
				if (cache[source[fastIdx]] == 0) {
					++count;
				}
				++cache[source[fastIdx++]];
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
}

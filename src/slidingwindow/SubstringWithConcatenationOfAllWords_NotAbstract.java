package slidingwindow;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

/*
 * Вам дана строка s и массив строк words. Все строки words имеют одинаковую длину.
 * 
 * Сцепленная строка — это строка, которая содержит в точности все строки любой перестановки сцепленных слов.
 * 
 * Например, если words = ["ab","cd","ef"], то "abcdef", "abefcd", "cdabef", "cdefab", "efabcd" и "efcdab" 
 * — это все сцепленные строки. 
 * "acdbef" не является сцепленной строкой, поскольку она не является конкатенацией какой-либо перестановки слов.
 * 
 * Верните массив начальных индексов всех сцепленных подстрок в s. Вы можете вернуть ответ в любом порядке.
 */

public class SubstringWithConcatenationOfAllWords_NotAbstract {

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ans = new ArrayList<>();

		Map<String, Integer> cache = new HashMap<>();
		for (String key : words)
			cache.put(key, cache.getOrDefault(key, 0) + 1);

		int len = words[0].length();
		int countWords = words.length;

		for (int i = 0; i < len; ++i) {
			Map<String, Integer> tmp = new HashMap<>();
			int count = 0;
			for (int j = i, begin = i; j + len <= s.length(); j += len) {
				String substrNewKey = s.substring(j, j + len);
				tmp.put(substrNewKey, tmp.getOrDefault(substrNewKey, 0) + 1);
				++count;

				if (count == countWords) {
					if (cache.equals(tmp))
						ans.add(begin);
					String remove = s.substring(begin, begin + len);
					tmp.computeIfPresent(remove, (k, v) -> (v > 1) ? v - 1 : null);
					--count;

					begin += len;
				}
			}
		}
		return ans;
	}

	@Test
	public void case1() {
		String s = "barfoothefoobarman";

		String[] words = {"foo", "bar"};
		int[] expected = {0, 9};
		List<Integer> ans = findSubstring(s, words);
		int[] actual = ans.stream().mapToInt(v -> v).toArray();

		for (int i = 0; i < expected.length; ++i) {
			assertEquals(expected[i], actual[i]);
		}
	}
}

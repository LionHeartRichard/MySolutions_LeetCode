package repeat;

import static org.junit.Assert.assertEquals;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class SubstringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		return new AbstractList<Integer>() {

			List<Integer> ans = new ArrayList<>();

			public void createList() {

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
			}

			@Override
			public int size() {
				if (ans.isEmpty())
					createList();
				return ans.size();
			}

			@Override
			public Integer get(int index) {
				return ans.get(index);
			}
		};
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

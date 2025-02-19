package slidingwindow;

import static org.junit.Assert.assertEquals;

import java.util.AbstractList;
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

public class SubstringWithConcatenationOfAllWords {

	public List<Integer> findSubstring(String s, String[] words) {
		return new AbstractList<Integer>() {

			List<Integer> ans = new ArrayList<>();

			private void createList() {
				int len = words[0].length();
				int countWords = words.length;

				// заполняем кэш, в качестве значений будет количество одинаковых слов
				Map<String, Integer> cache = new HashMap<>();
				for (String key : words)
					cache.put(key, cache.getOrDefault(key, 0) + 1);

				// внешний цикл обеспечивает все варианты смещения в строке относительно
				// вариантов ее деления на слова
				for (int i = 0; i < len; ++i) {
					// создаем мапу для сравнения с кэшом
					Map<String, Integer> tmp = new HashMap<>();
					// счетчик позволит отслеживать количество занесенных слов в мапу
					int count = 0;
					// цикл в которм мы проверям временную мапу с кэшом и формируем ответ
					for (int j = i, begin = i; j + len <= s.length(); j += len) {
						String subtrNewKey = s.substring(j, j + len);
						tmp.put(subtrNewKey, tmp.getOrDefault(subtrNewKey, 0) + 1);
						++count;

						if (count == countWords) {
							if (cache.equals(tmp))
								ans.add(begin);
							String remove = s.substring(begin, begin + len);
							// в случае если значение будет равно 0, то мы передадим методу
							// computeIfPresent значение null, в этом случае метод удалит ключ и мапы
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

package dinamicprograming;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class WordBraek {

	/*
	 * Добавить описание задачи
	 */

	// это вспомогательный метод для вызова основной логики
	public boolean wordBreak(String text, List<String> words) {
		// создаем мыссив для обозначения вхождений
		// true говорит нам о том что мы нашли для этой части текста слово в словаре
		boolean cache[] = new boolean[text.length() + 1];

		// вызываем функцию содержаший основную логику
		return check(text, cache, 0, words);
	}

	// ищем вхождения слов из словаря в тексте
	private boolean check(String text, boolean[] cache, int startIdx, List<String> words) {
		int len = text.length();

		// крайние случаи
		if (cache[startIdx])
			return false;

		// база рекурсии
		if (len == startIdx)
			return true;

		// проверяем все слова в словаре на то содержатся ли они в тексте
		for (String word : words) {
			int newIdx = startIdx + word.length();
			// если слово содержится в тексте - то вызываем проверку для следующего слова
			if (newIdx <= len && !cache[newIdx] && text.startsWith(word, startIdx)) {
				// рекурсивно производим проверку, для следующего слова
				// таким образом мы вызовем все проверки и они в итоге либо все пройдут
				// и мы получим true а инче ...
				if (check(text, cache, newIdx, words)) {
					return true;
				}
				cache[newIdx] = true;
			}
		}
		return false;
	}

	////////////////////////////// --------tests--------////////////////////////////////////

	@Test
	public void case1() {

		String s = "leetcode";
		List<String> wordDict = Arrays.asList("leet", "code");
		System.out.println("case1()");

		boolean actual = wordBreak(s, wordDict);
		assertTrue(actual);

	}

	@Test
	public void case2() {
		String s = "applepenapplepenapple";
		List<String> wordDict = Arrays.asList("apple", "pen");
		System.out.println("case2()");

		boolean actual = wordBreak(s, wordDict);
		assertTrue(actual);

	}

	@Test
	public void case3() {
		String s = "catsandog";
		System.out.println("case3()");
		List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

		boolean actual = wordBreak(s, wordDict);
		assertFalse(actual);

	}

	@Test
	public void case4() {
		String s = "bb";
		System.out.println("case4()");
		List<String> wordDict = Arrays.asList("a", "b", "bbb", "bbbb");

		boolean actual = wordBreak(s, wordDict);
		assertTrue(actual);

	}

	@Test
	public void case5() {
		String s = "a";
		System.out.println("case5()");
		List<String> wordDict = Arrays.asList("b");

		boolean actual = wordBreak(s, wordDict);
		assertFalse(actual);

	}

	@Test
	public void case6() {
		String s = "aaaaaaa";
		System.out.println("case6()");
		List<String> wordDict = Arrays.asList("aaaa", "aa");

		boolean actual = wordBreak(s, wordDict);
		assertFalse(actual);

	}

	@Test
	public void case7() {
		String s = "cars";
		System.out.println("case7()");
		List<String> wordDict = Arrays.asList("car", "ca", "rs");

		boolean actual = wordBreak(s, wordDict);
		assertTrue(actual);

	}

	@Test
	public void case8() {
		String s = "dogs";
		System.out.println("case8()");
		List<String> wordDict = Arrays.asList("dog", "s", "gs");

		boolean actual = wordBreak(s, wordDict);
		assertTrue(actual);

	}

}

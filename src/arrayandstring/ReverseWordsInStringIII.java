package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ReverseWordsInStringIII {
	/*
	 * Для строки s изменить порядок символов в каждом слове предложения, сохранив
	 * пробелы и начальный порядок слов.
	 */

	public String reverseWords(String s) {
		int len = s.length();
		char[] arr = s.toCharArray();
		for (int i = 0; i < len;) {
			for (; arr[i] == ' '; ++i) {
			}
			int j = i;
			for (; j < len && arr[j] != ' '; ++j) {
			}
			wordReverse(arr, i, j - 1);
			i = j;
		}
		return new String(arr);
	}

	private void wordReverse(char[] arr, int left, int right) {
		for (; left < right; ++left, --right) {
			char swap = arr[left];
			arr[left] = arr[right];
			arr[right] = swap;
		}
	}

	@Test
	void case1() {
		String s = "Let's take LeetCode contest", expected = "s'teL ekat edoCteeL tsetnoc";
		System.out.println(expected);
		String actual = reverseWords(s);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	@Test
	void case2() {
		String s = "Mr Ding", expected = "rM gniD";
		System.out.println(expected);
		String actual = reverseWords(s);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

}

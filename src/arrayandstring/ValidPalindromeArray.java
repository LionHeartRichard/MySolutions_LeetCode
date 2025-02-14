package arrayandstring;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class ValidPalindromeArray {
	public boolean isPalindrome(String source) {
		// обрабатываем крайние случаи
		if (source.length() == 1)
			return true;

		source = source.toLowerCase();
		// создаем асоциативный массив - который будет считать количество символов
		// 26 букв
		int[] counter = new int[26];

		// переводим строку в массив символов
		char[] array = source.toCharArray();

		int lIdx = 0, rIdx = array.length - 1;

		// перебираем массив и заполняем счетчик
		while (lIdx < rIdx) {

			char lCh = array[lIdx];
			boolean isChLeft = Character.isLetter(lCh);

			char rCh = array[rIdx];
			boolean isChRight = Character.isLetter(rCh);

			if (isChLeft && isChRight) {
				int left = lCh - 'a' >= 0 ? lCh - 'a' : lCh - 'A';
				int right = rCh - 'a' >= 0 ? rCh - 'a' : rCh - 'A';
				++counter[left];
				--counter[right];
				if (counter[left] != 0)
					return false;
				++lIdx;
				--rIdx;
			} else if (!isChLeft) {
				++lIdx;
			} else {
				--rIdx;
			}
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

package repeat.repeat;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/** Найти H-Index исследователя, */

public class HIndex {
	// Паттерн КЛЮЧ-Значение/ЗНАЧЕНИЕ-Ключ
	public int hIndex(int[] arr) {
		int len = arr.length;

		int[] cache = new int[len + 1];
		for (int idx : arr)
			++cache[Math.min(len, idx)];

		int ans = 0;
		for (int idx = len; idx >= 1; --idx) {
			ans += cache[idx];
			if (ans >= idx)
				return idx;
		}
		return 0;
	}

	@Test
	public void case1() {
		int[] citations = {3, 0, 6, 1, 5};
		// в данном случае три исследовательские работы были процетированы

		int expected = 3;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] citations = {1, 3, 1};

		int expected = 1;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}

	@Test
	public void case3() {
		int[] citations = {100};

		int expected = 1;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}

	@Test
	public void case4() {
		int[] citations = {0, 1};

		int expected = 1;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}

	@Test
	public void case5() {
		int[] citations = {11, 15};

		int expected = 2;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}

	@Test
	public void case6() {
		int[] citations = {1, 2, 2};

		int expected = 2;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}
}
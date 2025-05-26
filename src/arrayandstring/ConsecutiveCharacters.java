package arrayandstring;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class ConsecutiveCharacters {

	public int maxPower(String s) {
		char[] arr = s.toCharArray();
		int count = 1, keepCount = 1;
		for (int i = 0; i < arr.length - 1; ++i) {
			if (arr[i] != arr[i + 1]) {
				keepCount = Math.max(keepCount, count);
				count = 1;
				continue;
			}
			++count;
		}
		return Math.max(count, keepCount);
	}

	@Test
	void case1() {

		String s = "leetcode";
		int expected = 2;
		// Explanation: The substring "ee" is of length 2 with the character 'e' only.
		int actual = maxPower(s);
		assertEquals(expected, actual);
	}

	@Test
	void case2() {
		String s = "abbcccddddeeeeedcba";
		int expected = 5;
		// Explanation: The substring "eeeee" is of length 5 with the character 'e'
		// only.
		int actual = maxPower(s);
		assertEquals(expected, actual);
	}

	@Test
	void case3() {
		String s = "cc";
		int expected = 2;
		int actual = maxPower(s);
		assertEquals(expected, actual);
	}

}

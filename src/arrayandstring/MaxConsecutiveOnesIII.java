package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Дан двоичный массив nums и целое число k. 
 * Верните максимальное количество последовательных единиц в массиве, 
 * если вы можете перевернуть не более k нулей.
 */

public class MaxConsecutiveOnesIII {
	/*
	 * Разобрать основательно
	 */

	public int longestOnes(int[] arr, int k) {
		int ans = 0, zeroCount = 0;
		for (int left = 0, right = 0; right < arr.length; ++right) {
			if (arr[right] == 0) {
				++zeroCount;
			}
			while (zeroCount > k) {
				if (arr[left] == 0) {
					--zeroCount;//????????????
				}
				++left;
			}
			ans = Math.max(ans, right - left + 1);
		}
		return ans;
	}

	@Test
	void case1() {
		int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
		int k = 2, expected = 6;
		int actual = longestOnes(nums, k);
		assertEquals(expected, actual);
	}

	@Test
	void case2() {
		int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
		int k = 3, expected = 10;
		int actual = longestOnes(nums, k);
		assertEquals(expected, actual);
	}

}

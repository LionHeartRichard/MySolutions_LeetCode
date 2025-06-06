package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class SubarraySumEqualsK {

	/*
	 * Для массива целых чисел nums и целого числа k вернуть общее количество
	 * подмассивов, сумма которых равна k.
	 */

	public int subarraySum(int[] arr, int k) {

		int ans = 0, key = 0;
		Map<Integer, Integer> cache = new HashMap<>();
		cache.put(0, 1);

		for (int value : arr) {
			key += value;
			if (cache.containsKey(key - k))
				ans += cache.get(key - k);
			cache.put(key, cache.getOrDefault(key, 0) + 1);
		}
		return ans;
	}

	@Test
	void case1() {
		int[] nums = {1, 1, 1};
		int k = 2, expected = 2;
		int actual = subarraySum(nums, k);
		assertEquals(expected, actual);
	}

	@Test
	void case2() {
		int[] nums = {1, 2, 3};
		int k = 3, expected = 2;
		int actual = subarraySum(nums, k);
		assertEquals(expected, actual);
	}

}

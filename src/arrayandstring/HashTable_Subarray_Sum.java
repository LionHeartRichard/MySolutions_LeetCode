package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HashTable_Subarray_Sum {

	/*
	 * Для массива целых чисел nums и целого числа k вернуть общее количество
	 * подмассивов, сумма которых равна k.
	 */

	private static final int GOLDEN_NUMBER = 0x9E3779BA; // Это число известно как "константа золотого числа"

	public static int subarraySum(int[] arr, final int k) {

		final int mask = getMask(arr.length);

		final int[] hashTable = new int[mask + 1];
		int ans = 0, sum = 0;
		int zeros = 1; // для учета случаев, когда сумма становится равной 0

		for (final int n : arr) {
			sum += n;
			final int diff = sum - k;
			if (diff != 0) {
				int idx = diff * GOLDEN_NUMBER & mask;
				while (true) {
					final int key = hashTable[idx];
					if (key == 0)
						break;
					if (key == diff) {
						ans += hashTable[idx + 1];
						break;
					}
					idx = idx + 2 & mask;
				}
			} else {
				ans += zeros;
			}
			if (sum != 0) {
				int idx = sum * GOLDEN_NUMBER & mask;
				while (true) {
					final int key = hashTable[idx];
					if (key == 0) {
						hashTable[idx] = sum;
						hashTable[idx + 1] = 1;
						break;
					}
					if (key == sum) {
						++hashTable[idx + 1];
						break;
					}
					idx = idx + 2 & mask;
				}
			} else {
				++zeros;
			}
		}
		return ans;
	}

	public static int getMask(int h) {
		h |= h >> 1;
		h |= h >> 2;
		h |= h >> 4;
		h |= h >> 8;
		return (h << 1) | 31;
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

package arrayandstring;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
/*
 * Дан целочисленный массив nums и целое число k, вернуть true, если nums имеет хороший подмассив, 
 * или false в противном случае.
 * 
 * Хороший подмассив — это подмассив, где: его длина не менее двух, 
 * и сумма элементов подмассива кратна k.
 * 
 * Обратите внимание, что: Подмассив — это непрерывная часть массива.
 * Целое число x кратно k, если существует целое число n, 
 * такое что x = n * k. 0 всегда кратно k.
 */

public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] == 0 && nums[i - 1] == 0)
				return true;
		}
		
		Set<Integer> cashe = new HashSet<>(nums.length);
		int sum = 0;
		for (int num : nums) {
			int keepSum = sum;
			sum = (sum + num) % k;
			if (cashe.contains(sum)) {
				return true;
			}
			cashe.add(keepSum);
		}
		return false;
	}

	@Test
	void case1() {

		int[] nums = {23, 2, 4, 6, 7};
		int k = 6;
		assertTrue(checkSubarraySum(nums, k));
		// Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up
		// to 6.
	}

	@Test
	void case2() {
		int[] nums = {23, 2, 6, 4, 7};
		int k = 6;
		assertTrue(checkSubarraySum(nums, k));
		/*
		 * Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose
		 * elements sum up to 42. 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an
		 * integer.
		 */
	}

	@Test
	void case3() {
		int[] nums = {23, 2, 6, 4, 7};
		int k = 13;
		assertTrue(!checkSubarraySum(nums, k));
	}

	@Test
	void case4() {
		int[] nums = {23, 2, 4, 6, 6};
		int k = 7;
		assertTrue(checkSubarraySum(nums, k));
	}

}

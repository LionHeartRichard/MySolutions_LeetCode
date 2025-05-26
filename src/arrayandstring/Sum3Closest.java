package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Sum3Closest {
	/*
	 * Дан массив целых чисел nums длины n и целевое число, найдите три целых числа
	 * в nums, чтобы сумма была ближе всего к целевому числу.
	 * 
	 * Верните сумму трех целых чисел.
	 * 
	 * Можно предположить, что каждый вход будет иметь ровно одно решение.
	 */

	public int threeSumClosest(int[] nums, int target) {
		int len = nums.length;
		if (len < 3)
			return 0;
		Arrays.sort(nums);

		int sumClosest = nums[0] + nums[1] + nums[2];
		int minDiff = Math.abs(target - sumClosest);

		for (int i = 0; i < len - 2; ++i) {
			int left = i + 1;
			int right = len - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				int diff = Math.abs(target - sum);
				if (diff < minDiff) {
					minDiff = diff;
					sumClosest = sum;
				}
				if (sum < target) {
					++left;
					continue;
				}
				--right;
			}
		}
		return sumClosest;
	}

	@Test
	void case1() {
		int[] nums = {-1, 2, 1, -4};
		int target = 1, expected = 2;
		int actual = threeSumClosest(nums, target);
		assertEquals(expected, actual);
	}

	@Test
	void case2() {
		int[] nums = {0, 0, 0};
		int target = 1, expected = 0;
		int actual = threeSumClosest(nums, target);
		assertEquals(expected, actual);
	}

}

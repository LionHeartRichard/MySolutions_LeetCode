package slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/*
 * Дан массив положительных целых чисел nums и положительное целое число target, вернуть минимальную длину
 * подмассива, сумма которого больше или равна target. Если такого подмассива нет, вернуть 0.
 */

public class MinimumSizeSubarraySum {

	public int minSubArrayLen(int target, int[] arr) {

		int len = arr.length, left = 0;
		int sum = 0, window = len + 1;

		// складываем все элементы
		// как только сумма превысила цель
		// вычитаем элементы попутно расчитывая окно
		for (int right = 0; right < len; ++right) {
			sum += arr[right];
			while (sum >= target) {
				window = Math.min(window, right - left + 1);
				sum -= arr[left++];
			}
		}
		return window == len + 1 ? 0 : window;
	}

	@Test
	public void case1() {
		int target = 7;
		int[] nums = {2, 3, 1, 2, 4, 3};

		int expected = 2;
		// [4,3] has the minimal length under the problem constraint.
		int actual = minSubArrayLen(target, nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		int target = 4;
		int[] nums = {1, 4, 4};

		int expected = 1;
		int actual = minSubArrayLen(target, nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case3() {
		int target = 11;
		int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};

		int expected = 0;
		int actual = minSubArrayLen(target, nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case4() {
		int target = 11;
		int[] nums = {1, 2, 3, 4, 5};

		int expected = 3;
		int actual = minSubArrayLen(target, nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case5() {
		int target = 15;
		int[] nums = {1, 2, 3, 4, 5};

		int expected = 5;
		int actual = minSubArrayLen(target, nums);

		assertEquals(expected, actual);
	}
}

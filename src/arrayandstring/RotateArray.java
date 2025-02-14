package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Дан целочисленный массив nums. Повернуть массив вправо на k шагов, где k — неотрицательное число.
 */

public class RotateArray {

	public void rotate(int[] nums, int k) {
		// находим опорный элемент, так как k может быть больше длины
		// то используем целочисленное деление
		k %= nums.length;
		// переворачиваем весь массив
		reverseArray(nums, 0, nums.length - 1);
		// переворачиваем необходимый "ОТРЕЗОК" обратно, от начала массива до опорного
		reverseArray(nums, 0, k - 1);
		// возвращяем на место элементы от порного включительно до конца массива
		reverseArray(nums, k, nums.length - 1);
	}

	// классический алгоритм для реверса массива а также связного списка
	public void reverseArray(int[] nums, int beginIdx, int endIdx) {
		while (beginIdx < endIdx) {
			int swapItem = nums[beginIdx];
			nums[beginIdx++] = nums[endIdx];
			nums[endIdx--] = swapItem;
		}
	}

	@Test
	public void case1() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;

		int[] expected = { 5, 6, 7, 1, 2, 3, 4 };
		rotate(nums, k);

		for (int idx = 0; idx < expected.length; ++idx) {
			assertEquals(expected[idx], nums[idx]);
		}
//		rotate 1 steps to the right: [7,1,2,3,4,5,6]
//		rotate 2 steps to the right: [6,7,1,2,3,4,5]
//		rotate 3 steps to the right: [5,6,7,1,2,3,4]
	}

	@Test
	public void case2() {
		int[] nums = { -1, -100, 3, 99 };
		int k = 2;

		int[] expected = { 3, 99, -1, -100 };
		rotate(nums, k);

		for (int idx = 0; idx < expected.length; ++idx) {
			assertEquals(expected[idx], nums[idx]);
		}
	}

}

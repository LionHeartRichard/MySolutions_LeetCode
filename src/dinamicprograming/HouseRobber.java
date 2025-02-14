package dinamicprograming;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class HouseRobber {

	private int[] cach;

	public int rob(int[] nums) {
		int len = nums.length;
		if (len == 1)
			return nums[0];

		cach = new int[len];
		Arrays.fill(cach, -1);

		cach[0] = nums[0];
		cach[1] = Math.max(nums[0], nums[1]);

		return recursionWithCach(nums, len - 1);
	}

	private int recursionWithCach(int[] nums, int n) {
		// база рекурсии
		if (n <= 1)
			return cach[n];
		// условие на проверку сохранности значения функции в кэше
		if (cach[n] == -1) {
			// проверка домов через один или через два лучше для наибольшего результата
			cach[n] = Math.max(recursionWithCach(nums, n - 1), nums[n] + recursionWithCach(nums, n - 2));
		}
		// если мы уже вычисляли значение функции то возвращяем значение кэша без
		// вычислений - вызова функций
		// и построения дерева вызовов
		return cach[n];
	}

	@Test
	public void case1() {
		int[] nums = { 1, 2, 3, 1 };

		int expected = 4;
		int actual = rob(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] nums = { 2, 7, 9, 3, 1 };

		int expected = 12;
		int actual = rob(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case3() {
		int[] nums = { 2, 1, 1, 2 };

		int expected = 4;
		int actual = rob(nums);

		assertEquals(expected, actual);
	}
}

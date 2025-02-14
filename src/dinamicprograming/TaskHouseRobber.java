package dinamicprograming;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class TaskHouseRobber {

	// варинт решение задачи на какую цепочку домов выбрать, для наилучшего
	// результата
	// программирование снизу
	public int rob(int[] nums) {
		// крайний случай
		int len = nums.length;
		if (len == 1)
			return nums[0];

		// создаем кэш
		int[] cach = new int[len];

		// добавляем базу для динамического программирования
		cach[0] = nums[0];
		cach[1] = Math.max(nums[0], nums[1]);

		// выполняем в цикле соответствующие вычисления с добавлением кэш
		for (int idx = 2; idx < len; ++idx) {
			cach[idx] = Math.max(cach[idx - 1], nums[idx] + cach[idx - 2]);
		}

		// возращяем последний элемент кэша
		return cach[len - 1];
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

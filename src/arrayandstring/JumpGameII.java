package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Вам дан массив целых чисел nums длины n. Вы изначально находитесь в nums[0].
 * Каждый элемент nums[i] представляет максимальную длину прямого перехода от индекса i. 
 * Другими словами, если вы находитесь в nums[i], вы можете перейти к любому nums[i + j], где:
 * 0 <= j <= nums[i] и i + j < n 
 * Верните минимальное количество переходов для достижения nums[n - 1]. 
 * Тестовые случаи генерируются таким образом, чтобы вы могли достичь nums[n - 1].
 */

// изящное решение
// паттерн медленный и быстрый указатель 
public class JumpGameII {

	public int jump(int[] nums) {

		int len = nums.length;
		int countJumps = 0;

		// создаем быстрый индекс который будет равен максимальному возможному прыжку в
		// настоящий момент
		int fastIdx = 0;
		// сохраняем предыдущее место положение для того чтобы знать сколько прыжков нам
		// нужно совершить
		int keepFastIdx = 0;

		for (int slowIdx = 0; slowIdx < len - 1; ++slowIdx) {

			// ищем максимальный прыжок который можем совершить
			fastIdx = Math.max(fastIdx, slowIdx + nums[slowIdx]);

			// если мы проитерировались до сохраненного прыжка следовательно
			// мы прибавляем кол-во прыжков
			if (keepFastIdx == slowIdx) {
				++countJumps;
				keepFastIdx = fastIdx;
			}
		}

		return countJumps;
	}

	@Test
	public void case1() {
		int[] nums = { 2, 3, 1, 1, 4 };

		int expected = 2;
		int actual = jump(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] nums = { 2, 3, 0, 1, 4 };

		int expected = 2;
		int actual = jump(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case3() {
		int[] nums = { 0 };

		int expected = 0;
		int actual = jump(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case4() {
		int[] nums = { 1, 2 };

		int expected = 1;
		int actual = jump(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case5() {
		int[] nums = { 3, 2, 1 };

		int expected = 1;
		int actual = jump(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case6() {
		int[] nums = { 2, 3, 1 };

		int expected = 1;
		int actual = jump(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case7() {
		int[] nums = { 1, 1, 1, 1 };

		int expected = 3;
		int actual = jump(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case8() {
		int[] nums = { 1, 2, 0, 10, 5, 2, 0, 2, 1, 4, 1, 1, 1 };

		int expected = 3;
		int actual = jump(nums);

		assertEquals(expected, actual);
	}
}

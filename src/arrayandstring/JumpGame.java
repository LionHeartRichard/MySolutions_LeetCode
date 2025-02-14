package arrayandstring;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

/*
 * Вам дан целочисленный массив nums. Изначально вы находитесь на первом индексе массива, 
 * и каждый элемент в массиве представляет максимальную длину прыжка в этой позиции.
 * Верните true, если вы можете достичь последнего индекса, или false в противном случае.
 */

// паттерн медленный и быстрый указатель
public class JumpGame {

	public boolean canJump(int[] nums) {

		int len = nums.length;
		// создаем переменную куда будем записывать максимальный возможный прыжок
		// это быстрое перемещение по массиву согласно задачи, поэтому быстрый
		// указатель-индекс
		int fastIdx = 0;

		// итерируемся по всему массиву
		for (int slowIdx = 0; slowIdx < len; ++slowIdx) {
			// критическое условие для всех алгоритмов этого паттерна
			// при достижении-превышении медленного указателя над быстрым
			if (slowIdx > fastIdx)
				return false;
			// узнаем что больше максимальный прыжок или сколько мы проитерировались
			fastIdx = Math.max(fastIdx, slowIdx + nums[slowIdx]);
			// если мы пропрыгали до последнего элемента то true
			if (fastIdx >= len - 1)
				return true;
		}
		return false;
	}

	@Test
	public void case1() {
		int[] nums = { 2, 3, 0, 0, 4 };

		boolean actual = canJump(nums);

		assertTrue(actual);
	}

	@Test
	public void case2() {
		int[] nums = { 3, 2, 1, 0, 4 };

		boolean actual = canJump(nums);

		assertFalse(actual);
	}

	@Test
	public void case3() {
		int[] nums = { 2, 0, 2 };

		boolean actual = canJump(nums);

		assertTrue(actual);
	}
}

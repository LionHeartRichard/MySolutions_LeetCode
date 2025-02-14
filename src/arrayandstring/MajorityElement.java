package arrayandstring;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

public class MajorityElement {

	// Алгоритм Бойера-Мура (Boyer-Moore Voting Algorithm)

	public Integer majorityElement(int[] nums) {

		// назначаем число кандидат
		int candidate = -1;
		// выставляем счетчик - который определяет - является ли число кандидатом
		int count = 0;

		// 1-й проход: Нахождение числа кандидата
		for (int idx = 0; idx < nums.length; ++idx) {
			candidate = count == 0 ? nums[idx] : candidate;
			// за счет счетчика мы определяем число кандидат
			// если число мало встречается то мы в конце концов обнулим счетчик
			// и получим число кандидат
			count += nums[idx] == candidate ? 1 : -1;
		}

		// 2-й проход: Проверка кандидата
		count = 0;
		for (int idx = 0; idx < nums.length; ++idx) {
			count += nums[idx] == candidate ? 1 : 0;
		}

		// если мы нашли кандидата, то возвращяем его иначе null
		return count > nums.length / 2 ? candidate : null;
	}

	@Test
	public void case1() {
		int[] nums = { 3, 2, 3 };

		int expected = 3;
		int actual = majorityElement(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };

		int expected = 2;
		int actual = majorityElement(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case3() {
		int[] nums = { 3, 2, 1, 1, 1, 2, 2 };

		Integer actual = majorityElement(nums);

		assertNull(actual);
	}
}

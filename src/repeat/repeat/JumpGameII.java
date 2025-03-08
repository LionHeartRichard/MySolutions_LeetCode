package repeat.repeat;

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

public class JumpGameII {

	public int jump(int[] arr) {
		int count = 0, keepFast = 0;
		for (int slow = 0, fast = 0; slow < arr.length - 1; ++slow) {
			fast = Math.max(fast, slow + arr[slow]);
			if (keepFast == slow) {
				keepFast = fast;
				++count;
			}
		}
		return count;
	}

	@Test
	public void case1() {
		int[] nums = {2, 3, 1, 1, 4};

		int expected = 2;
		int actual = jump(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] nums = {2, 3, 0, 1, 4};

		int expected = 2;
		int actual = jump(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case3() {
		int[] nums = {0};

		int expected = 0;
		int actual = jump(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case4() {
		int[] nums = {1, 2};

		int expected = 1;
		int actual = jump(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case5() {
		int[] nums = {3, 2, 1};

		int expected = 1;
		int actual = jump(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case6() {
		int[] nums = {2, 3, 1};

		int expected = 1;
		int actual = jump(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case7() {
		int[] nums = {1, 1, 1, 1};

		int expected = 3;
		int actual = jump(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case8() {
		int[] nums = {1, 2, 0, 10, 5, 2, 0, 2, 1, 4, 1, 1, 1};

		int expected = 3;
		int actual = jump(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case57() {
		int[] nums = {1};

		int expected = 0;
		int actual = jump(nums);

		assertEquals(expected, actual);
	}
}

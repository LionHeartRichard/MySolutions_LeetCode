package repeat.repeat;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

//паттерн медленный и быстрый указатель
public class JumpGame {
	public boolean canJump(int[] arr) {
		for (int slow = 0, fast = 0; slow < arr.length; ++slow) {
			if (slow > fast)
				return false;
			fast = Math.max(fast, slow + arr[slow]);
			if (fast >= arr.length - 1)
				return true;
		}
		return false;
	}

	@Test
	public void case1() {
		int[] nums = {2, 3, 0, 0, 4};

		boolean actual = canJump(nums);

		assertTrue(actual);
	}

	@Test
	public void case2() {
		int[] nums = {3, 2, 1, 0, 4};

		boolean actual = canJump(nums);

		assertFalse(actual);
	}

	@Test
	public void case3() {
		int[] nums = {2, 0, 2};

		boolean actual = canJump(nums);

		assertTrue(actual);
	}
}
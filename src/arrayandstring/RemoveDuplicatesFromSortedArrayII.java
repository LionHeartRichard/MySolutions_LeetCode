package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//классический алгоритм быстрого и медленного указателя
public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
		int slowIdx = 2, fastIdx = 2;
		for (fastIdx = 2; fastIdx < nums.length; ++fastIdx) {
			if (nums[fastIdx] != nums[slowIdx - 2])
				nums[slowIdx++] = nums[fastIdx];
		}
		return slowIdx;
	}

	@Test
	public void case1() {
		int[] nums = { 1, 1, 1, 2, 2, 3 };

		int expectedK = 5;
		int[] expectedArr = { 1, 1, 2, 2, 3 };
		int actualK = removeDuplicates(nums);

		assertEquals(expectedK, actualK);
		for (int idx = 0; idx < actualK; ++idx) {
			assertEquals(expectedArr[idx], nums[idx]);
		}
	}

	@Test
	public void case2() {
		int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };

		int expectedK = 7;
		int[] expectedArr = { 0, 0, 1, 1, 2, 3, 3 };
		int actualK = removeDuplicates(nums);

		assertEquals(expectedK, actualK);
		for (int idx = 0; idx < actualK; ++idx) {
			assertEquals(expectedArr[idx], nums[idx]);
		}
	}
}

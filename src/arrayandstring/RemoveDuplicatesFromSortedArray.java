package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//классический алгоритм быстрого и медленного указателя
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int fastIdx = 1, slowIdx = 1;
		for (fastIdx = 1; fastIdx < nums.length; ++fastIdx) {
			if (nums[fastIdx - 1] != nums[fastIdx]) {
				nums[slowIdx++] = nums[fastIdx];
			}
		}
		return slowIdx;
	}

	@Test
	public void case1() {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

		int expectedK = 5;
		int[] expectedArr = { 0, 1, 2, 3, 4 };
		int actualK = removeDuplicates(nums);

		assertEquals(expectedK, actualK);
		for (int idx = 0; idx < actualK; ++idx) {
			assertEquals(expectedArr[idx], nums[idx]);
		}
	}

	@Test
	public void case2() {
		int[] nums = { 1, 1, 2 };

		int expectedK = 2;
		int[] expectedArr = { 1, 2 };
		int actualK = removeDuplicates(nums);

		assertEquals(expectedK, actualK);
		for (int idx = 0; idx < actualK; ++idx) {
			assertEquals(expectedArr[idx], nums[idx]);
		}
	}
}

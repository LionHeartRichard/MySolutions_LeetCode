package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Дан целочисленный массив nums и целочисленный val, удалить все вхождения val в nums на месте. 
 * Порядок элементов может быть изменен. Затем вернуть количество элементов в nums, которые не равны val.
 */

//классический алгоритм быстрого и медленного указателя
public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		int fastIdx = 0, slowIdx = 0;
		for (fastIdx = 0; fastIdx < nums.length; ++fastIdx) {
			if (nums[fastIdx] != val) {
				nums[slowIdx++] = nums[fastIdx];
			}
		}
		return slowIdx;
	}

	@Test
	public void case1() {
		int[] nums = { 3, 2, 2, 3 };
		int val = 3;

		int expectedK = 2;
		int[] expectedArr = { 2, 2 };
		int actualK = removeElement(nums, val);

		assertEquals(expectedK, actualK);
		for (int idx = 0; idx < actualK; ++idx) {
			assertEquals(expectedArr[idx], nums[idx]);
		}
	}
}

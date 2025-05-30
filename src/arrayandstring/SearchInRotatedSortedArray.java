package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SearchInRotatedSortedArray {
	public int search(int[] arr, int target) {
		int left = 0, right = arr.length - 1;

		while (left <= right) {

			int mid = (left + right) >>> 1; // побитный сдвиг равносилен делению на 2
			if (arr[mid] == target)
				return mid;

			if (arr[left] <= arr[mid]) {
				if (arr[left] <= target && target < arr[mid])
					right = mid - 1;
				else
					left = mid + 1;
			} else {
				if (arr[mid] < target && target <= arr[right])
					left = mid + 1;
				else
					right = mid - 1;
			}
		}
		return -1;
	}

	@Test
	void case1() {

		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int target = 0, expected = 4;
		int actual = search(nums, target);
		assertEquals(expected, actual);
	}

	@Test
	void case2() {
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int target = 3, expected = -1;
		int actual = search(nums, target);
		assertEquals(expected, actual);
	}

	@Test
	void case3() {
		int[] nums = {1};
		int target = 0, expected = -1;
		int actual = search(nums, target);
		assertEquals(expected, actual);
	}

	@Test
	void case4() {
		int[] nums = {1, 3};
		int target = 3, expected = 1;
		int actual = search(nums, target);
		assertEquals(expected, actual);
	}

	@Test
	void case5() {
		int[] nums = {1};
		int target = 1, expected = 0;
		int actual = search(nums, target);
		assertEquals(expected, actual);
	}

	@Test
	void case6() {
		int[] nums = {1, 3, 5};
		int target = 1, expected = 0;
		int actual = search(nums, target);
		assertEquals(expected, actual);
	}

	@Test
	void case7() {
		int[] nums = {5, 1, 3};
		int target = 3, expected = 2;
		int actual = search(nums, target);
		assertEquals(expected, actual);
	}
}

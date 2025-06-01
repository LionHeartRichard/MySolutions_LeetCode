package arrayandstring;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

/*
 * Найти первую и последнюю позицию элемента в отсортированном массиве
 */

public class SearchRange {
	public int[] searchRange(int[] arr, int target) {
		int[] ans = {-1, -1};
		ans[0] = binarySearch(arr, target, false);
		if (ans[0] != -1)
			ans[1] = binarySearch(arr, target, true);
		return ans;
	}

	private int binarySearch(int[] arr, int target, boolean hasFirstIndex) {
		int ans = -1, len = arr.length, left = 0, right = len - 1;
		while (left <= right) {
			int mid = (right + left) >>> 1;
			if (arr[mid] < target) {
				left = mid + 1;
				continue;
			}
			if (arr[mid] > target) {
				right = mid - 1;
				continue;
			}
			if (!hasFirstIndex) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
			ans = mid;
		}
		return ans;
	}

	@Test
	void case1() {
		int[] nums = {5, 7, 7, 8, 8, 10}, expected = {3, 4};
		int target = 8;
		int[] actual = searchRange(nums, target);
		assertArrayEquals(expected, actual);
	}

	@Test
	void case3() {
		int[] nums = {1, 3}, expected = {0, 0};
		int target = 1;
		int[] actual = searchRange(nums, target);
		assertArrayEquals(expected, actual);
	}

	@Test
	void case4() {
		int[] nums = {5, 7, 7, 8, 8, 10}, expected = {-1, -1};
		int target = 6;
		int[] actual = searchRange(nums, target);
		assertArrayEquals(expected, actual);
	}

	@Test
	void case5() {
		int[] nums = {}, expected = {-1, -1};
		int target = 0;
		int[] actual = searchRange(nums, target);
		assertArrayEquals(expected, actual);
	}

	@Test
	void case6() {
		int[] nums = {1, 4}, expected = {1, 1};
		int target = 4;
		int[] actual = searchRange(nums, target);
		assertArrayEquals(expected, actual);
	}

	@Test
	void case7() {
		int[] nums = {5, 7, 7, 8, 8, 10}, expected = {3, 4};
		int target = 8;
		int[] actual = searchRange(nums, target);
		assertArrayEquals(expected, actual);
	}

	@Test
	void case8() {
		int[] nums = {1, 2, 2}, expected = {1, 2};
		int target = 2;
		int[] actual = searchRange(nums, target);
		assertArrayEquals(expected, actual);
	}

	@Test
	void case9() {
		int[] nums = {1, 1, 2}, expected = {0, 1};
		int target = 1;
		int[] actual = searchRange(nums, target);
		assertArrayEquals(expected, actual);
	}

	@Test
	void case10() {
		int[] nums = {0, 0, 1, 2, 2}, expected = {0, 1};
		int target = 0;
		int[] actual = searchRange(nums, target);
		assertArrayEquals(expected, actual);
	}
}

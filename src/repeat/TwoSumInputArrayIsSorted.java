package repeat;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class TwoSumInputArrayIsSorted {
	public int[] twoSum(int[] arr, int target) {
		int left = 0, right = arr.length - 1;
		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum > target) {
				--right;
				continue;
			}
			if (sum < target) {
				++left;
				continue;
			}
			return new int[] {left + 1, right + 1};
		}
		return new int[] {};
	}

	@Test
	public void case0() {
		int[] numbers = {2, 7, 11, 15};
		int target = 9;

		int[] expected = {1, 2};
		int[] actual = twoSum(numbers, target);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void case1() {
		int[] numbers = {2, 3, 4};
		int target = 6;

		int[] expected = {1, 3};
		int[] actual = twoSum(numbers, target);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] numbers = {-1, 0};
		int target = -1;

		int[] expected = {1, 2};
		int[] actual = twoSum(numbers, target);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void case15() {
		int[] arr = {12, 13, 23, 28, 43, 44, 59, 60, 61, 68, 70, 86, 88, 92, 124, 125, 136, 168, 173, 173, 180, 199,
				212, 221, 227, 230, 277, 282, 306, 314, 316, 321, 325, 328, 336, 337, 363, 365, 368, 370, 370, 371, 375,
				384, 387, 394, 400, 404, 414, 422, 422, 427, 430, 435, 457, 493, 506, 527, 531, 538, 541, 546, 568, 583,
				585, 587, 650, 652, 677, 691, 730, 737, 740, 751, 755, 764, 778, 783, 785, 789, 794, 803, 809, 815, 847,
				858, 863, 863, 874, 887, 896, 916, 920, 926, 927, 930, 933, 957, 981, 997};
		int target = 542;

		int[] expected = {24, 32};
		int[] actual = twoSum(arr, target);

		assertArrayEquals(expected, actual);
	}
}

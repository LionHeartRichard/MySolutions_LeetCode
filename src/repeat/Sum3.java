package repeat;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/*
 * Дан целочисленный массив nums, вернуть все триплеты [nums[i], nums[j], nums[k]] такие, 
 * что i != j, i != k и j != k, и nums[i] + nums[j] + nums[k] == 0.
 * 
 * Constraints:
 	3 <= nums.length <= 3000
 */

public class Sum3 {
	public List<List<Integer>> threeSum(int[] arr) {
		return new AbstractList<>() {
			List<List<Integer>> ans;

			@Override
			public int size() {
				if (ans == null)
					ans = createList(arr);
				return ans.size();
			}

			@Override
			public List<Integer> get(int index) {
				if (ans == null)
					ans = createList(arr);
				return ans.get(index);
			}
		};
	}

	private List<List<Integer>> createList(int[] arr) {
		List<List<Integer>> ans = new ArrayList<>();
		int len = arr.length;
		Arrays.sort(arr);
		for (int i = 0; i < len - 2 && arr[i] <= 0; ++i) {
			if (i > 0 && arr[i] == arr[i - 1])
				continue;
			twoSum(ans, arr, i + 1, len - 1, -arr[i]);
		}
		return ans;
	}

	private void twoSum(List<List<Integer>> ans, int[] arr, int left, int right, int target) {
		while (left < right) {
			if (arr[left] + arr[right] > target) {
				--right;
				continue;
			}
			if (arr[left] + arr[right] < target) {
				++left;
				continue;
			}

			ans.add(Arrays.asList(-target, arr[left++], arr[right--]));

			while (left <= right && arr[left] == arr[left - 1])
				++left;
		}
	}

	@Test
	public void case1() {
		int[] nums = {-1, 0, 1, 2, -1, -4};

		List<List<Integer>> expected = new ArrayList<>();
		List<Integer> expectedSubListA = new ArrayList<>(Arrays.asList(-1, -1, 2));
		List<Integer> expectedSubListB = new ArrayList<>(Arrays.asList(-1, 0, 1));
		expected.add(expectedSubListA);
		expected.add(expectedSubListB);
		List<List<Integer>> actual = threeSum(nums);

		for (int idx = 0; idx < expected.size(); ++idx) {
			List<Integer> currentExpected = expected.get(idx);
			List<Integer> currentActual = actual.get(idx);
			assertThat(currentExpected).containsExactlyInAnyOrderElementsOf(currentActual);
		}
	}

	@Test
	public void case2() {
		int[] nums = {0, 0, 0};

		List<List<Integer>> expected = new ArrayList<>();
		List<Integer> expectedSubListA = new ArrayList<>(Arrays.asList(0, 0, 0));
		expected.add(expectedSubListA);
		List<List<Integer>> actual = threeSum(nums);

		for (int idx = 0; idx < actual.size(); ++idx) {
			List<Integer> currentExpected = expected.get(idx);
			List<Integer> currentActual = actual.get(idx);
			assertThat(currentExpected).containsExactlyInAnyOrderElementsOf(currentActual);
		}
	}

	@Test
	public void case3() {
		int[] nums = {-1, 0, 1, 0};

		List<List<Integer>> expected = new ArrayList<>();
		List<Integer> expectedSubListA = new ArrayList<>(Arrays.asList(-1, 0, 1));
		expected.add(expectedSubListA);
		List<List<Integer>> actual = threeSum(nums);

		for (int idx = 0; idx < actual.size(); ++idx) {
			List<Integer> currentExpected = expected.get(idx);
			List<Integer> currentActual = actual.get(idx);
			assertThat(currentExpected).containsExactlyInAnyOrderElementsOf(currentActual);
		}
	}

}

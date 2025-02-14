package arrayandstring;

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
		AbstractList<List<Integer>> ans = new AbstractList<List<Integer>>() {
			List<List<Integer>> swap;

			@Override
			public int size() {
				if (swap == null)
					swap = returnSwapList(arr);
				return swap.size();
			}

			@Override
			public List<Integer> get(int index) {
				if (swap == null)
					swap = returnSwapList(arr);
				return swap.get(index);
			}
		};
		return ans;
	}

	private List<List<Integer>> returnSwapList(int[] arr) {
		int len = arr.length;
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(arr);

		for (int idx = 0; idx < len - 2 && arr[idx] <= 0; ++idx) {
			if (idx != 0 && arr[idx] == arr[idx - 1])
				continue;
			twoSum(idx + 1, -arr[idx], arr, ans);
		}
		return ans;
	}

	private void twoSum(int leftIdx, int target, int[] arr, List<List<Integer>> ans) {
		int rightIdx = arr.length - 1;

		while (leftIdx < rightIdx) {
			if (arr[leftIdx] + arr[rightIdx] > target) {
				--rightIdx;
				continue;
			}
			if (arr[leftIdx] + arr[rightIdx] < target) {
				++leftIdx;
				continue;
			}

			ans.add(Arrays.asList(-target, arr[leftIdx++], arr[rightIdx--]));

			while (leftIdx <= rightIdx && arr[leftIdx] == arr[leftIdx - 1]) {
				++leftIdx;
			}
		}
	}

	@Test
	public void case1() {
		int[] nums = { -1, 0, 1, 2, -1, -4 };

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
		int[] nums = { 0, 0, 0 };

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
		int[] nums = { -1, 0, 1, 0 };

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

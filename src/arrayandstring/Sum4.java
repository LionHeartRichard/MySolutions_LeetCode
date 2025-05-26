package arrayandstring;

import static org.junit.Assert.assertArrayEquals;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Sum4 {
	/*
	 * Дан массив nums из n целых чисел, вернуть массив всех уникальных четверок
	 * 
	 * 0 <= a, b, c, d < n
	 * 
	 * a, b, c, and d are distinct.
	 * 
	 * nums[a] + nums[b] + nums[c] + nums[d] == target
	 */

	public List<List<Integer>> fourSum(int[] arr, int target) {
		if (arr.length < 4)
			return Collections.emptyList();
		return new AbstractList<List<Integer>>() {
			List<List<Integer>> ans;

			@Override
			public int size() {
				if (ans == null)
					ans = createList(arr, target);
				return ans.size();
			}

			@Override
			public List<Integer> get(int index) {
				if (ans == null)
					ans = createList(arr, target);
				return ans.get(index);
			}
		};
	}

	private List<List<Integer>> createList(int[] arr, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(arr);
		int len = arr.length;
		for (int i = 0; i < len - 3; ++i) {
			if (i > 0 && arr[i - 1] == arr[i])
				continue;
			for (int j = i + 1; j < len - 2; ++j) {
				if (j > i + 1 && arr[j - 1] == arr[j])
					continue;
				int left = j + 1;
				int right = len - 1;
				while (left < right) {
					long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];
					if (sum < target) {
						++left;
						continue;
					}
					if (sum > target) {
						--right;
						continue;
					}
					ans.add(Arrays.asList(arr[i], arr[j], arr[left++], arr[right--]));

					while (left < right && arr[left] == arr[left - 1]) {
						++left;
					}
					while (left < right && arr[right] == arr[right + 1]) {
						--right;
					}
				}
			}
		}
		return ans;
	}

	@Test
	void case1() {
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		int[][] expected = {{-2, -1, 1, 2}, {-2, 0, 0, 2}, {-1, 0, 0, 1}};
		List<List<Integer>> actualList = fourSum(nums, target);
		int[][] actual = new int[3][4];

	}

	@Test
	void case2() {
		int[] nums = {2, 2, 2, 2, 2};
		int target = 8;
		int[][] expected = {{2, 2, 2, 2}};
		List<List<Integer>> actualList = fourSum(nums, target);
		int[][] actual = new int[1][4];
	}
}

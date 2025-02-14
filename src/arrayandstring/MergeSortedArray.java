package arrayandstring;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class MergeSortedArray {

	// классический алгоритм объединения массивов
	public void merge(int[] ans, int lenM, int[] arrN, int lenN) {

		int idx = 0, mIdx = 0, nIdx = 0;
		int[] arrM = Arrays.copyOf(ans, lenM);

		while (mIdx < lenM && nIdx < lenN) {
			if (arrM[mIdx] <= arrN[nIdx]) {
				ans[idx++] = arrM[mIdx++];
			} else {
				ans[idx++] = arrN[nIdx++];
			}
		}

		while (mIdx < lenM) {
			ans[idx++] = arrM[mIdx++];
		}

		while (nIdx < lenN) {
			ans[idx++] = arrN[nIdx++];
		}
	}

	@Test
	public void case1() {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int m = 3;
		int[] nums2 = { 2, 5, 6 };
		int n = 3;

		int[] expected = { 1, 2, 2, 3, 5, 6 };
		merge(nums1, m, nums2, n);

		assertArrayEquals(expected, nums1);
	}

	@Test
	public void case2() {
		int[] nums1 = { 1 };
		int m = 1;
		int[] nums2 = {};
		int n = 0;

		int[] expected = { 1 };
		merge(nums1, m, nums2, n);

		assertArrayEquals(expected, nums1);
	}

	@Test
	public void case3() {

		int[] nums1 = { 0 };
		int m = 0;
		int[] nums2 = { 1 };
		int n = 1;
		int[] expected = { 1 };
		merge(nums1, m, nums2, n);

		assertArrayEquals(expected, nums1);
	}

}

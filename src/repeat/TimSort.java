package repeat;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TimSort {

	public static final int THRESHOLD = 32;

	public void timSort(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i += THRESHOLD)
			insertionSort(arr, i, Math.min(i + THRESHOLD, len));

		for (int size = THRESHOLD; size < len; size *= 2) {
			for (int begin = 0; begin < len; begin += size * 2) {
				int mid = begin + size - 1;
				int n = Math.min(mid + size, len - 1);

				if (mid < n) {
					merge(arr, begin, mid, n);
				}
			}
		}
	}

	private void merge(int[] arr, int begin, int mid, int n) {
		int i, j, idx;
		int lenLeft = mid - begin + 1;
		int lenRight = n - mid;

		int[] arrLeft = new int[lenLeft];
		int[] arrRight = new int[lenRight];
		for (i = 0; i < lenLeft; ++i)
			arrLeft[i] = arr[begin + i];
		for (j = 0; j < lenRight; ++j)
			arrRight[j] = arr[mid + j + 1];

		idx = 0;
		i = 0;
		j = 0;
		while (i < lenLeft && j < lenRight) {
			if (arrLeft[i] <= arrRight[j]) {
				arr[idx++] = arrLeft[i++];
			} else {
				arr[idx++] = arrRight[j++];
			}
		}
		while (i < lenLeft)
			arr[idx++] = arrLeft[i++];
		while (j < lenRight)
			arr[idx++] = arrRight[j++];

	}

	private void insertionSort(int[] arr, int i, int len) {
		int swap, slow, fast;
		for (slow = i + 1; slow < len; ++slow) {
			swap = arr[slow];
			fast = slow - 1;
			while (fast >= 0 && arr[fast] > swap)
				arr[fast + 1] = arr[fast--];
			arr[++fast] = swap;
		}
	}

	@Test
	public void case1() {
		int[] actual = {6, -9, 10, 97, 0, 56, -1, 30, 10};
		int[] expected = Arrays.copyOf(actual, actual.length);
		Arrays.sort(expected);

		timSort(actual);

		assertArrayEquals(expected, actual);
	}

}

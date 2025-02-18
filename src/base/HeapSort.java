package base;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class HeapSort {

	public void heapSort(int[] arr) {
		int len = arr.length;
		for (int i = len / 2 - 1; i >= 0; --i) {
			heapify(arr, i, len);
		}

		for (int i = len - 1; i >= 0; --i) {
			int swap = arr[0];
			arr[0] = arr[i];
			arr[i] = swap;

			heapify(arr, 0, i);
		}
	}

	private void heapify(int[] arr, int i, int len) {
		int idx = i;
		int left = idx * 2 + 1, right = left + 1;

		if (left < len && arr[left] > arr[idx])
			idx = left;
		if (right < len && arr[right] > arr[idx])
			idx = right;

		if (i != idx) {
			int swap = arr[i];
			arr[i] = arr[idx];
			arr[idx] = swap;

			heapify(arr, idx, len);
		}
	}

	@Test
	public void case1() {
		int[] actual = {6, -9, 10, 97, 0, 56, -1, 30, 10};
		int[] expected = Arrays.copyOf(actual, actual.length);
		Arrays.sort(expected);

		heapSort(actual);

		assertArrayEquals(expected, actual);
	}

}

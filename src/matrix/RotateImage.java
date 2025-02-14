package matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Вам дана матрица n x n 2D, представляющая изображение, поверните изображение на 90 градусов 
 * (по часовой стрелке).
 * Вам нужно повернуть изображение на месте, что означает, что вам нужно напрямую изменить входную матрицу 2D. 
 * НЕ выделяйте другую матрицу 2D и не выполняйте поворот.
 */

public class RotateImage {

	public void rotate(int[][] matrix) {
		int len = matrix.length;
		swapRowsByColumns(matrix, len);
		for (int rowIdx = 0; rowIdx < len; ++rowIdx) {
			reverseRow(matrix, rowIdx, 0, len - 1);
		}
	}

	private void swapRowsByColumns(int[][] matrix, int m) {
		for (int idx = 0; idx < m; ++idx) {
			for (int j = idx + 1; j < m; ++j) {
				int temp = matrix[idx][j];
				matrix[idx][j] = matrix[j][idx];
				matrix[j][idx] = temp;
			}
		}
	}

	private void reverseRow(int[][] matrix, final int rowIdx, int leftIdx, int rightIdx) {
		while (leftIdx < rightIdx) {
			int swap = matrix[rowIdx][leftIdx];
			matrix[rowIdx][leftIdx++] = matrix[rowIdx][rightIdx];
			matrix[rowIdx][rightIdx--] = swap;
		}
	}

	@Test
	public void case1() {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// { 7, 8, 9 }{ 4, 5, 6 }{ 1, 2, 3 }
		int len = matrix.length;
		int[][] expected = { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
		rotate(matrix);

		for (int rowIdx = 0; rowIdx < len; ++rowIdx) {
			for (int colIdx = 0; colIdx < len; ++colIdx) {
				assertEquals(expected[rowIdx][colIdx], matrix[rowIdx][colIdx]);
			}
		}
	}

	@Test
	public void case2() {
		int[][] matrix = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		int len = matrix.length;
		int[][] expected = { { 15, 13, 2, 5 }, { 14, 3, 4, 1 }, { 12, 6, 8, 9 }, { 16, 7, 10, 11 } };
		rotate(matrix);

		for (int rowIdx = 0; rowIdx < len; ++rowIdx) {
			for (int colIdx = 0; colIdx < len; ++colIdx) {
				assertEquals(expected[rowIdx][colIdx], matrix[rowIdx][colIdx]);
			}
		}
	}
}

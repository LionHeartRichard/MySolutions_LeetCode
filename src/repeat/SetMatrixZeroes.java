package repeat;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

/*
 * Дана целочисленная матрица m x n, если элемент равен 0, установите всю ее строку и столбец в 0. 
 * Вы должны сделать это на месте.
 */

public class SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		int m = matrix.length, n = matrix[0].length;
		boolean isFirstColumnZero = firstColumnIsZero(matrix, m);
		boolean isFirstRowZero = firstRowIsZero(matrix, n);

		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			}
		}

		if (isFirstColumnZero) {
			for (int i = 0; i < m; ++i) {
				matrix[i][0] = 0;
			}
		}
		if (isFirstRowZero) {
			for (int j = 0; j < n; ++j) {
				matrix[0][j] = 0;
			}
		}
	}

	private boolean firstColumnIsZero(int[][] matrix, int m) {
		for (int idx = 0; idx < m; ++idx) {
			if (matrix[idx][0] == 0)
				return true;
		}
		return false;
	}

	private boolean firstRowIsZero(int[][] matrix, int n) {
		for (int idx = 0; idx < n; ++idx) {
			if (matrix[0][idx] == 0)
				return true;
		}
		return false;
	}

	@Test
	public void case1() {
		int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
		int len = matrix.length;

		int[][] expected = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
		setZeroes(matrix);
		for (int idx = 0; idx < len; ++idx)
			assertArrayEquals(expected[idx], matrix[idx]);
	}

	@Test
	public void case2() {
		int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
		int len = matrix.length;

		int[][] expected = {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};
		setZeroes(matrix);
		for (int idx = 0; idx < len; ++idx)
			assertArrayEquals(expected[idx], matrix[idx]);
	}

}
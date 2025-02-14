package matrix;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
		int len = matrix.length;
		boolean firstRowZero = firstRowIsZero(matrix);
		boolean firstColZero = firstColumnIsZero(matrix);

		for (int rowIdx = 1; rowIdx < len; ++rowIdx)
			markZeroFirstElementInColumnsAndRows(matrix, rowIdx);

		for (int rowIdx = 1; rowIdx < len; ++rowIdx)
			setMatrixCellsToZeroBasedOnMarkers(matrix, rowIdx);

		if (firstRowZero) {
			for (int columnIdx = 0; columnIdx < matrix[0].length; ++columnIdx) {
				matrix[0][columnIdx] = 0;
			}
		}

		if (firstColZero) {
			for (int rowIdx = 0; rowIdx < len; rowIdx++) {
				matrix[rowIdx][0] = 0;
			}
		}
	}

	private void markZeroFirstElementInColumnsAndRows(int[][] matrix, int rowIdx) {
		for (int columnIdx = 1; columnIdx < matrix[0].length; ++columnIdx) {
			if (matrix[rowIdx][columnIdx] == 0) {
				matrix[rowIdx][0] = 0;
				matrix[0][columnIdx] = 0;
			}
		}
	}

	private void setMatrixCellsToZeroBasedOnMarkers(int[][] matrix, int rowIdx) {
		for (int columnIdx = 1; columnIdx < matrix[0].length; ++columnIdx) {
			if (matrix[rowIdx][0] == 0 || matrix[0][columnIdx] == 0)
				matrix[rowIdx][columnIdx] = 0;
		}
	}

	private boolean firstColumnIsZero(int[][] matrix) {
		for (int[] row : matrix) {
			if (row[0] == 0)
				return true;
		}
		return false;
	}

	private boolean firstRowIsZero(int[][] matrix) {
		for (int cell : matrix[0]) {
			if (cell == 0)
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

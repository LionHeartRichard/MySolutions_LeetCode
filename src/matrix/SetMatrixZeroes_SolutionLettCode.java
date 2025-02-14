package matrix;

public class SetMatrixZeroes_SolutionLettCode {
	public void setZeroes(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		boolean firstRowZero = false, firstColZero = false;

		// Check if the first row and first column need to be zero
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0)
				firstColZero = true;
		}
		for (int j = 0; j < n; j++) {
			if (matrix[0][j] == 0)
				firstRowZero = true;
		}

		// Mark zeros in the first row and column
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// Set matrix cells to zero based on markers
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		// Zero out the first row if needed
		if (firstRowZero) {
			for (int j = 0; j < n; j++) {
				matrix[0][j] = 0;
			}
		}

		// Zero out the first column if needed
		if (firstColZero) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}

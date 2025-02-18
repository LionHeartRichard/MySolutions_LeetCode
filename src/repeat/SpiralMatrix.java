package repeat;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/*
 * Дана матрица m x n, вернуть все элементы матрицы в спиральном порядке.
 */
public class SpiralMatrix {

	public static final int DIRECTIONS = 4;
	public static final int[][] DIR_MATRIX = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static int idx;

	private List<Integer> ans = new ArrayList<>();

	public List<Integer> spiralOrder(int[][] matrix) {
		idx = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] cache = new boolean[m][n];
		walk(matrix, cache, 0, 0, m, n);
		return ans;
	}

	private void walk(int[][] matrix, boolean[][] cache, int i, int j, final int m, final int n) {
		if (ans.size() == m * n)
			return;
		int keepIdx = idx;
		if (i < 0 || i >= m || j < 0 || j >= n) {
			idx = (idx + 1) % DIRECTIONS;
			return;
		}
		if (cache[i][j]) {
			idx = (idx + 1) % DIRECTIONS;
			return;
		}

		cache[i][j] = true;
		ans.add(matrix[i][j]);

		walk(matrix, cache, i + DIR_MATRIX[idx][0], j + DIR_MATRIX[idx][1], m, n);
		if (keepIdx != idx) {
			walk(matrix, cache, i + DIR_MATRIX[idx][0], j + DIR_MATRIX[idx][1], m, n);
		}

	}

	@Test
	public void case1() {
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

		List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5));
		List<Integer> actual = spiralOrder(matrix);

		expected.forEach(v -> assertTrue(actual.contains(v)));
	}
}

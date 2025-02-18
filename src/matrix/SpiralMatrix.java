package matrix;

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
	// создаем массив изменения указателей (направлений)
	public static final int[][] DIR_MATRIX = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	// Direction: 0=right 1=down 2=left 3=up
	// задаем начальный указатель направления
	private static int idx;
	// инициализируем лист для хранения ответа
	private List<Integer> ans = new ArrayList<>();

	public List<Integer> spiralOrder(int[][] matrix) {
		idx = 0;
		int m = matrix.length, n = matrix[0].length;
		// создаем кэш для того чтобы значть были ли мы в этой точке матрицы
		boolean[][] cache = new boolean[m][n];
		walk(matrix, cache, 0, 0, m, n);
		return ans;
	}

	// рекурсивно обходим матрицу
	public void walk(int[][] matrix, boolean[][] cache, int i, int j, final int m, final int n) {
		// крайний случай как только ответ равен размеру матрицы заканчиваем рекурсию
		if (ans.size() == m * n) {
			return;
		}

		// сохраняем индекс
		int keepIdx = idx;
		// 2-й крайний случай проверяем выход за пределы матрицы
		if (i >= m || i < 0 || j >= n || j < 0) {
			// пересчитываем индекс направления
			idx = (idx + 1) % DIRECTIONS;
			return;
		}

		// 3-й крайний на посещение матрицы
		if (cache[i][j]) {
			// пересчитываем индекс направления
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
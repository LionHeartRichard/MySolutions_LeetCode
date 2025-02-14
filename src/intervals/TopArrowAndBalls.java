package intervals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TopArrowAndBalls {

	/*
	 * У нас есть воздушные шарики расположенные на одной плоскости представленные
	 * матрицей points Сколько потребуется стрел для поражения всех шаров
	 */

	public int findMinArrowShots(int[][] points) {
		if (points.length == 0)
			return 0;

		// сортируем двумерный массив по его вторым элементам
		// т.е. по конечной границе интревала
		Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

		// как минимум нам понадобится одна стрела
		int arrows = 1;
		// задаем начальную позицию для проверки вхождения интервалов
		int currentEnd = points[0][1];

		for (int idx = 0; idx < points.length; ++idx) {
			// если мы вышли за предел интервала следовательно нам понадобиться еще одна
			// стрела для поражения шариков
			if (currentEnd < points[idx][0]) {
				++arrows;
				currentEnd = points[idx][1];
			}
		}
		return arrows;
	}

	@Test
	public void testCase1() {
		int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };

		int expected = 2;
		int actual = findMinArrowShots(points);

		assertEquals(expected, actual);
	}

	@Test
	public void testCase2() {
		int[][] points = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };

		int expected = 4;
		int actual = findMinArrowShots(points);

		assertEquals(expected, actual);
	}

	@Test
	public void testCase3() {
		int[][] points = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };

		int expected = 2;
		int actual = findMinArrowShots(points);

		assertEquals(expected, actual);
	}

	@Test
	public void testCase4() {
		int[][] points = { { 0, 9 }, { 1, 8 }, { 7, 8 }, { 1, 6 }, { 9, 16 }, { 7, 13 }, { 7, 10 }, { 6, 11 }, { 6, 9 },
				{ 9, 13 } };

		int expected = 3;
		int actual = findMinArrowShots(points);

		assertEquals(expected, actual);
	}
}
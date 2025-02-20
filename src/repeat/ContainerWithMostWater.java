package repeat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Вам дан целочисленный массив height длины n. Нарисовано n вертикальных линий, 
 * так что две конечные точки i-й линии — (i, 0) 
 * и (i, height[i]). Найдите две линии, которые вместе с осью x образуют контейнер, 
 * так что контейнер содержит больше всего воды.
 * Верните максимальное количество воды, которое может хранить контейнер. 
 * Обратите внимание, что вы не можете наклонить контейнер.
 */

public class ContainerWithMostWater {
	public int maxArea(int[] arr) {
		// максимальный объем воды зависит от длины массива и высоты 2х максимальных
		// элементов массива
		// берем два указателя и перемещяемся с краев к центру, исходя из наибольшего
		// объема воды
		int left = 0, right = arr.length - 1;
		int ans = 0;
		while (left < right) {
			int height = Math.min(arr[left], arr[right]);
			ans = Math.max(ans, height * (right - left));
			// зачастую мы можем ускорить алгоритм применив к нему цикличное условие
			// как в этой задаче
			while (left < right && arr[left] <= height)
				++left;
			while (left < right && arr[right] <= height)
				--right;
		}
		return ans;
	}

	@Test
	public void case1() {
		int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

		int expected = 49;
		int actual = maxArea(height);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] height = {1, 1};

		int expected = 1;
		int actual = maxArea(height);

		assertEquals(expected, actual);
	}
}

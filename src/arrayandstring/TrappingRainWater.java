package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Даны n неотрицательных целых чисел, представляющих карту высот, где ширина каждого столбца равна 1. 
 * Рассчитайте, сколько воды она может удержать после дождя.
 */

public class TrappingRainWater {
	public int trap(int[] height) {

		int totalWater = 0;
		// классическое начало для алгоритмов левый и правый указатель
		//
		int leftIdx = 0, rightIdx = height.length - 1;

		// создаем базовые элементы по которым будем считать уровень воды
		// очень важно что начинаем базового исходить что левый "борт" равен 0, а вот
		// правый равен крайнему элементу соответственно
		int lMax = 0, rMax = height[rightIdx];

		// создаем классический цикл при реализации паттерна левый и правый указатель
		while (leftIdx < rightIdx) {
			if (height[leftIdx] <= height[rightIdx]) {
				if (height[leftIdx] < lMax) {
					totalWater += lMax - height[leftIdx];
				} else {
					lMax = height[leftIdx];
				}
				++leftIdx;
			} else {
				if (height[rightIdx] < rMax) {
					totalWater += rMax - height[rightIdx];
				} else {
					rMax = height[rightIdx];
				}
				--rightIdx;
			}
		}
		return totalWater;
	}

	@Test
	public void case1() {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

		int expected = 6;
		int actual = trap(height);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] height = { 4, 2, 0, 3, 2, 5 };

		int expected = 9;
		int actual = trap(height);

		assertEquals(expected, actual);
	}

	@Test
	public void case3() {
		int[] height = { 5, 2, 2, 3, 0, 3, 0, 4, 0, 5 };

		int expected = 26;
		int actual = trap(height);

		assertEquals(expected, actual);
	}

	@Test
	public void case4() {
		int[] height = { 2, 0, 0, 0, 4, 0, 0, 0, 0, 0, 4, 0, 0, 2 };

		int expected = 30;
		int actual = trap(height);

		assertEquals(expected, actual);
	}

	@Test
	public void case5() {
		int[] height = { 4, 2, 3 };

		int expected = 1;
		int actual = trap(height);

		assertEquals(expected, actual);
	}
}

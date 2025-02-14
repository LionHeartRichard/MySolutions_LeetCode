package arrayandstring;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

/*
 * Дано 1-индексный массив целых чисел, который уже отсортирован в неубывающем порядке, найдите два числа, которые в сумме дают определенное целевое число. Пусть эти два числа будут numbers[index1] и numbers[index2], где 1 <= index1 < index2 <= numbers.length.
 * Верните индексы двух чисел, index1 и index2, сложенные на единицу, как целочисленный массив [index1, index2] длины 2.
 * Тесты генерируются таким образом, что существует ровно одно решение. Вы не можете использовать один и тот же элемент дважды.
 * Ваше решение должно использовать только постоянное дополнительное пространство.
 */

public class TwoSumInputArrayIsSorted {
	public int[] twoSum(int[] numbers, int target) {

		int leftIdx = 0, rightIdx = numbers.length - 1;

		while (leftIdx < rightIdx) {
			int sum = numbers[leftIdx] + numbers[rightIdx];
			if (sum == target)
				return new int[] { leftIdx + 1, rightIdx + 1 };
			if (sum < target)
				++leftIdx;
			else
				--rightIdx;
		}

		return new int[] {};
	}

	@Test
	public void case0() {
		int[] numbers = { 2, 7, 11, 15 };
		int target = 9;

		int[] expected = { 1, 2 };
		int[] actual = twoSum(numbers, target);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void case1() {
		int[] numbers = { 2, 3, 4 };
		int target = 6;

		int[] expected = { 1, 3 };
		int[] actual = twoSum(numbers, target);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] numbers = { -1, 0 };
		int target = -1;

		int[] expected = { 1, 2 };
		int[] actual = twoSum(numbers, target);

		assertArrayEquals(expected, actual);
	}
}

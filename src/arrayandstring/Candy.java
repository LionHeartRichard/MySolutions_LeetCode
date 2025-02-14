package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * В ряд стоят n детей. Каждому ребенку присваивается рейтинг, указанный в целочисленном массиве ratings.
 * Вы раздаете конфеты этим детям, соблюдая следующие требования:
 * У каждого ребенка должна быть хотя бы одна конфета.
 * Дети с более высоким рейтингом получают больше конфет, чем их соседи.
 * Верните минимальное количество конфет, которое вам нужно иметь, чтобы раздать конфеты детям.
 */

public class Candy {
	public int candy(int[] ratings) {

		int len = ratings.length;
		// обрабатываем крайний случай
		if (len <= 1) {
			return 1;
		}

		// создаем кэш для хранения промежуточных результатов
		int[] cache = new int[len];
		// обходим массив с начала и смотрим на выполнение условия
		for (int idx = 1; idx < len; ++idx) {
			// если ребенок выше рейтингом, то он должен получить больше конфет
			if (ratings[idx] > ratings[idx - 1])
				cache[idx] = cache[idx - 1] + 1;
		}

		// обходим с конца и проверяем рейтинг теперь в обратном порядке
		for (int idx = len - 2; idx >= 0; --idx) {
			if (ratings[idx] > ratings[idx + 1])
				cache[idx] = Math.max(cache[idx], cache[idx + 1] + 1);
		}

		// суммируем сохраненные значения и получаем ответ
		int ans = 0;
		// также добавляем еденицу так как массив заполняем нулями
		for (int item : cache) {
			ans += item + 1;
		}
		return ans;
	}

	@Test
	public void case0() {
		int[] ratings = { 10, 12, 13, 5, 1, 18, 19, 20, 22 };

		int expected = 23;
		int actual = candy(ratings);

		assertEquals(expected, actual);
	}

	@Test
	public void case1() {
		int[] ratings = { 1, 0, 2 };

		int expected = 5;
		int actual = candy(ratings);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] ratings = { 1, 2, 2 };

		int expected = 4;
		int actual = candy(ratings);

		assertEquals(expected, actual);
	}

	@Test
	public void case3() {
		int[] ratings = { 1, 2 };

		int expected = 3;
		int actual = candy(ratings);

		assertEquals(expected, actual);
	}

	@Test
	public void case4() {
		int[] ratings = { 4 };

		int expected = 1;
		int actual = candy(ratings);

		assertEquals(expected, actual);
	}

	@Test
	public void case5() {
		int[] ratings = { 2, 1 };

		int expected = 3;
		int actual = candy(ratings);

		assertEquals(expected, actual);
	}

	@Test
	public void case6() {
		int[] ratings = { 1, 3, 2, 2, 1 };

		int expected = 7;
		int actual = candy(ratings);

		assertEquals(expected, actual);
	}
}

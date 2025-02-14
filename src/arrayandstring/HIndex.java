package arrayandstring;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/*
 *  Найти H-Index исследователя,
 */

public class HIndex {
	// Паттерн КЛЮЧ-Значение/ЗНАЧЕНИЕ-Ключ
	public int hIndex(int[] citations) {
		// так как максимальный ответ - значение (Value) не может превышать length
		// то используем в качестве структуры данных массив
		// создаем кэш который будет хранит Value = Key (Idx)
		// кэш который содержит потенциальные ответы
		// value = idx!!!!!!!!!!!
		int len = citations.length;
		int[] cache = new int[len + 1];
		// используем значение в качестве ключа-индекса
		for (int value : citations) {
			++cache[Math.min(value, len)];
		}

		// формируем ответ согласно задачи
		// ответ в таком паттерне это всегда зависимотсть ключа-индекса от значения
		int currentValue = 0;
		for (int idx = len; idx >= 0; --idx) {
			currentValue += cache[idx];
			if (currentValue >= idx) {
				return idx;
			}
		}
		return 0;
	}

	@Test
	public void case1() {
		int[] citations = { 3, 0, 6, 1, 5 };
		// в данном случае три исследовательские работы были процетированы

		int expected = 3;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] citations = { 1, 3, 1 };

		int expected = 1;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}

	@Test
	public void case4() {
		int[] citations = { 100 };

		int expected = 1;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}

	@Test
	public void case5() {
		int[] citations = { 0, 1 };

		int expected = 1;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}

	@Test
	public void case6() {
		int[] citations = { 11, 15 };

		int expected = 2;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}

	@Test
	public void case7() {
		int[] citations = { 1, 2, 2 };

		int expected = 2;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}
}

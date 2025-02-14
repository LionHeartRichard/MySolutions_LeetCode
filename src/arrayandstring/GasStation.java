package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * На кольцевом маршруте расположено n заправочных станций, где количество бензина на i-й станции равно gas[i]. 
 * У вас есть автомобиль с неограниченным бензобаком, и поездка от i-й станции до следующей (i + 1)-й станции стоит cost[i] бензина. Вы начинаете поездку с пустым баком на одной из заправок.
 * Даны два целочисленных массива gas и cost, верните индекс начальной заправочной станции, если вы можете объехать весь маршрут один раз по часовой стрелке, в противном случае верните -1. ​​Если существует решение, оно гарантированно уникально.
 */

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		// считаем общее количество бензина для того чтобы доехать в круговую
		// а также количество всего возможного для заправки
		int len = gas.length, totalGas = 0, totalCoast = 0;
		for (int idx = 0; idx < len; ++idx) {
			totalCoast += cost[idx];
			totalGas += gas[idx];
		}

		if (totalCoast > totalGas)
			return -1;

		int fastIdxBegin = 0;
		int currentGas = 0;
		// благодаря условию что у нас есть уникальное решение мы можем обойти массив
		// еще один раз и получить решение
		for (int slowIdx = 0; slowIdx < len; ++slowIdx) {
			currentGas += gas[slowIdx] - cost[slowIdx];
			// если начальное положение-позиция не подходит изменяем ее
			if (currentGas < 0) {
				fastIdxBegin = slowIdx + 1;
				currentGas = 0;
			}
		}

		return fastIdxBegin;
	}

	@Test
	public void case1() {
		int[] gas = { 1, 2, 3, 4, 5 }, cost = { 3, 4, 5, 1, 2 };

		int expected = 3;
		int actual = canCompleteCircuit(gas, cost);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] gas = { 2, 3, 4 }, cost = { 3, 4, 3 };

		int expected = -1;
		int actual = canCompleteCircuit(gas, cost);

		assertEquals(expected, actual);
	}

	@Test
	public void case3() {
		int[] gas = { 5, 1, 2, 3, 4 }, cost = { 4, 4, 1, 5, 1 };

		int expected = 4;
		int actual = canCompleteCircuit(gas, cost);

		assertEquals(expected, actual);
	}

	@Test
	public void case4() {
		int[] gas = { 5, 8, 2, 8 }, cost = { 6, 5, 6, 6 };
		int expected = 3;
		int actual = canCompleteCircuit(gas, cost);

		assertEquals(expected, actual);
	}
}

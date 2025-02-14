package dinamicprograming;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class Fibonacci {

	private int[] cache = new int[48];

	// Пример динамического программирования сверху!!!!!!!!
	// фцнкция с кэшем, которая рекурсивно вызывает себя для вычисления
	// предыдущих значений
	public int fib(int n) {
		if (n <= 1)
			return n; // return 1 - если нужно исключиьт повторение в начале
		if (cache[n] == 0)
			cache[n] = fib(n - 1) + fib(n - 2);
		return cache[n];
	}

	// Пример динамического программирования снизу!!!!!!!!
	public int fibDinamic(int n) {
		int[] arrayFib = new int[n + 1];
		arrayFib[1] = 1;
		for (int i = 2; i <= n; ++i) {
			arrayFib[i] = arrayFib[i - 1] + arrayFib[i - 2];
		}
		return arrayFib[n];
	}

	// служебный метод для работы с процедурой
	public int procedureStyleFib(int n) {
		int[] ans = new int[n + 1];
		ans[1] = 1;
		fibProcedure(ans, 2);
		return ans[n];
	}

	// процедура которая рекурсивно считает число фибоначи
	// применяет метод программирования снизу
	private void fibProcedure(int[] ans, int idx) {
		if (idx >= ans.length)
			return;

		ans[idx] = ans[idx - 1] + ans[idx - 2];
		fibProcedure(ans, idx + 1);
	}

	// Пример расчета факториала
	public long getFactorial(int n) {
		long factorial = 1;
		for (int i = 2; i <= n; ++i) {
			factorial *= i;
		}
		return factorial;
	}

	@Test
	public void testFibRecursionWithCach() {
		int num = 46;
		int actual = fib(num);

		System.out.println("fib[" + num + "] = " + actual);

		int expected = 1836311903;

		assertEquals(expected, actual);
	}

	@Test
	public void testFibDinamic() {
		int num = 46;
		int actual = fibDinamic(num);

		System.out.println("fibDinamic[" + num + "] = " + actual);

		int expected = 1836311903;

		assertEquals(expected, actual);
	}

	@Test
	public void testFactorial() {
		long actual = getFactorial(10);
		long expected = 3628800l;

		assertEquals(expected, actual);
	}

	@Test
	public void testProcedureStyleFib() {
		int num = 46;
		int actual = procedureStyleFib(num);

		System.out.println("procedureStyleFib[" + num + "] = " + actual);

		int expected = 1836311903;

		assertEquals(expected, actual);
	}

}

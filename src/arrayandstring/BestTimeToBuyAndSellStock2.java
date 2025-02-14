package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Вам дан целочисленный массив цен, где цены[i] — это цена данной акции на i-й день.
 * Каждый день вы можете решить купить и/или продать акцию. 
 * Вы можете держать не более одной акции в любой момент времени. 
 * Однако вы можете купить ее, а затем немедленно продать в тот же день.
 * Найдите и верните максимальную прибыль, которую вы можете получить.
 */

public class BestTimeToBuyAndSellStock2 {

	public int maxProfit(int[] prices) {
		int totalSum = 0;
		for (int idx = 1; idx < prices.length; ++idx) {
			totalSum += Math.max(0, prices[idx] - prices[idx - 1]);
		}
		return totalSum;
	}

	@Test
	public void case1() {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int expected = 7;

		int actual = maxProfit(prices);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] prices = { 1, 2, 3, 4, 5 };
		int expected = 4;

		int actual = maxProfit(prices);

		assertEquals(expected, actual);
	}

	@Test
	public void case3() {
		int[] prices = { 7, 6, 4, 3, 1 };
		int expected = 0;

		int actual = maxProfit(prices);

		assertEquals(expected, actual);
	}

	@Test
	public void case4() {
		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int expected = 8;

		int actual = maxProfit(prices);

		assertEquals(expected, actual);
	}

}

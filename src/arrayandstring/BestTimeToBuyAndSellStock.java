package arrayandstring;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Вам дан массив цен, где цены[i] — это цена данной акции на i-й день.
 * Вы хотите максимизировать свою прибыль, выбрав один день для покупки одной акции и выбрав другой 
 * день в будущем для продажи этой акции.
 * Верните максимальную прибыль, которую вы можете получить от этой транзакции. 
 * Если вы не можете получить никакой прибыли, верните 0.
 */

public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		// перебираем массив находим наименьший день для приобретения акции
		// находим наибольший профит
		int profit = 0;
		int buy = prices[0];
		for (int idx = 1; idx < prices.length; ++idx) {
			int currentPrice = prices[idx];
			if (buy > currentPrice) {
				buy = currentPrice;
			} else {
				profit = currentPrice - buy > profit ? currentPrice - buy : profit;
			}

		}
		return profit;
	}

	@Test
	public void case1() {
		int[] prices = { 7, 1, 5, 3, 6, 4 };

		int expected = 5;
		int actual = maxProfit(prices);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] prices = { 7, 6, 4, 3, 1 };

		int expected = 0;
		int actual = maxProfit(prices);

		assertEquals(expected, actual);
	}

}

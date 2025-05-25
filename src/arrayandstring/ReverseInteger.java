package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ReverseInteger {
	public int reverse(int x) {
		return recursiveSolution(x, 0);
	}

	private int recursiveSolution(int x, int ans) {
		if (x == 0)
			return ans;
		if (ans > Integer.MAX_VALUE / 10 || ans < Integer.MIN_VALUE / 10)
			return 0;
		int pivot = x % 10;
		x /= 10;
		ans = ans * 10 + pivot;
		return recursiveSolution(x, ans);
	}

	@Test
	void case1() {
		int x = 123, expected = 321;
		int actual = reverse(x);
		assertEquals(expected, actual);
	}

	@Test
	void case2() {
		int x = -123, expected = -321;
		int actual = reverse(x);
		assertEquals(expected, actual);
	}

	@Test
	void case3() {
		int x = 120, expected = 21;
		int actual = reverse(x);
		assertEquals(expected, actual);
	}

	@Test
	void case4() {
		int x = 901000, expected = 109;
		int actual = reverse(x);
		assertEquals(expected, actual);

	}

	@Test
	void case5() {
		int x = 1534236469, expected = 0;
		int actual = reverse(x);
		assertEquals(expected, actual);

	}

}

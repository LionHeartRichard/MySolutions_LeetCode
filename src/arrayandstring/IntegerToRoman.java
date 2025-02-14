package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class IntegerToRoman {

	private StringBuilder cache;

	public String intToRoman(int num) {
		cache = new StringBuilder();
		num = funTransform('*', '*', 'M', num, 1000);
		num = funTransform('M', 'D', 'C', num, 100);
		num = funTransform('C', 'L', 'X', num, 10);
		funTransform('X', 'V', 'I', num, 1);
		return cache.toString();
	}

	private int funTransform(char major, char mid, char minor, int num, int divider) {
		int count = num / divider;
		if (count <= 3) {
			while (count-- > 0) {
				cache.append(minor);
			}
			return num % divider;
		}
		if (count < 5) {
			cache.append(minor);
			cache.append(mid);
			return num % divider;
		}
		if (count == 5) {
			cache.append(mid);
			return num % divider;
		}
		if (count < 9) {
			cache.append(mid);
			while (count-- > 5) {
				cache.append(minor);
			}
			return num % divider;
		}
		cache.append(minor);
		cache.append(major);
		return num % divider;
	}

	@Test
	public void case1() {
		int num = 3749;

		String expected = "MMMDCCXLIX";
		String actual = intToRoman(num);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		int num = 58;

		String expected = "LVIII";
		String actual = intToRoman(num);

		assertEquals(expected, actual);
	}

	@Test
	public void case3() {
		int num = 1994;

		String expected = "MCMXCIV";
		String actual = intToRoman(num);

		assertEquals(expected, actual);
	}
}

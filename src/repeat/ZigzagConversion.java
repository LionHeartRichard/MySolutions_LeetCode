package repeat;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Строка "PAYPALISHIRING" написана зигзагом в заданном количестве строк, как здесь: 
 * (вы можете захотеть отобразить этот шаблон фиксированным шрифтом для лучшей читаемости)

P A H N
A P L S I I G
Y I R
А
 
 * затем прочитайте строку за строкой: "PAHNAPLSIIGYIR"
 * Напишите код, который возьмет строку и выполнит это преобразование с заданным количеством строк:
 */

public class ZigzagConversion {

	public String convert(String s, int numbersRows) {

		// обработка крайних случаев
		if (numbersRows == 1 || numbersRows >= s.length())
			return s;

		StringBuilder[] arr = new StringBuilder[Math.min(numbersRows, s.length())];
		for (int i = 0; i < arr.length; ++i)
			arr[i] = new StringBuilder();

		char[] source = s.toCharArray();

		int idx = 0;
		boolean goingDown = false;
		int n = arr.length - 1;
		for (char ch : source) {
			arr[idx].append(ch);
			goingDown = (idx == 0 || idx == n) ? !goingDown : goingDown;
			idx += goingDown ? 1 : -1;
		}

		StringBuilder ans = new StringBuilder();
		for (StringBuilder row : arr)
			ans.append(row);
		return ans.toString();
	}

	@Test
	public void case0() {

		String source = "МсГеАмОьМяДТАЫ";
		int numbersRows = 3;

		String expected = "МАМАсемьяТЫГОД";
		String actual = convert(source, numbersRows);

		assertEquals(expected, actual);
	}

	@Test
	public void case1() {
		String source = "PAYPALISHIRING";
		int numbersRows = 3;

		String expected = "PAHNAPLSIIGYIR";
		String actual = convert(source, numbersRows);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		String source = "PAYPALISHIRING";
		int numbersRows = 4;

		String expected = "PINALSIGYAHRPI";
		String actual = convert(source, numbersRows);

		assertEquals(expected, actual);
	}

	@Test
	public void case3() {
		String source = "A";
		int numbersRows = 1;

		String expected = "A";
		String actual = convert(source, numbersRows);

		assertEquals(expected, actual);
	}
}

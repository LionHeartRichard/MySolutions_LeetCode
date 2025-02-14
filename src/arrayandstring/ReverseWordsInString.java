package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ReverseWordsInString {

	public String reverseWords(String s) {
		// конвертируем строку в массив символов
		char[] input = s.toCharArray();
		// создаем выходной массив который будет хранить обратный порядок слов
		char[] output = new char[input.length];
		// вызываем функцию которая возвращяет реверсированный список слов в виде массив
		// output а также индекс последнего элемента чтобы исключить лишние пробелы
		// передаем туда два массива и начальный и конечный индекс
		int endIdx = reversWords(input, output, 0, input.length);
		// возвращяем новую строку из выходного массива символов!!!
		return new String(output, 0, endIdx);
	}

	// основная логика реализована в этой функции
	private int reversWords(char[] input, char[] output, int beginIdx, int endIdx) {
		// база рекурсии
		// исключаем лишние вызовы
		if (beginIdx == endIdx)
			return 0;
		// находим индекс начала слова/ символа/ цифры
		while (beginIdx < input.length && input[beginIdx] == ' ')
			++beginIdx;
		// ищем конец слова начиная с его начала в массиве символов
		endIdx = beginIdx;
		// находим конечный индекс где заканчиваются слово
		while (endIdx < input.length && input[endIdx] != ' ')
			++endIdx;
		// благодаря предыдущим циклам мы знаем где начинается и заканчивается слово
		// вызываем функцию ДЛЯ КАЖДОГО СЛОВА
		int outputStart = reversWords(input, output, endIdx, input.length);
		// если это не начала то мы разделяем слова пробелами
		if (outputStart > 0)
			output[outputStart++] = ' ';
		// осуществляем заполнение выходного массива соответствующими символами
		// начиная с последнего слова!!!
		for (int idx = beginIdx; idx < endIdx; ++idx) {
			output[outputStart++] = input[idx];
		}

		return outputStart;
	}

	@Test
	public void case1() {
		String s = "the sky is blue";

		String expected = "blue is sky the";
		String actual = reverseWords(s);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		String s = "  hello world  ";

		String expected = "world hello";
		String actual = reverseWords(s);

		assertEquals(expected, actual);
	}

	@Test
	public void case3() {
		String s = "a good   example";

		String expected = "example good a";
		String actual = reverseWords(s);

		assertEquals(expected, actual);
	}
}

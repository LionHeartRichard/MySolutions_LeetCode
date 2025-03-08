package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/*
 * Дано множество строк words и ширина maxWidth, отформатируйте текст так, 
 * чтобы каждая строка содержала ровно maxWidth символов и была полностью (влево и вправо) выровнена.
 */

public class TextJustification {

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> ans = new ArrayList<>();
		int left = 0;
		while (left < words.length) {
			// расчитываем сколько слов мы можем добавить в строку
			int right = getRightIdx(words, left, maxWidth);
			// выравниваем строку
			String row = justifyRow(words, left, right, maxWidth);
			ans.add(row);
			left = right + 1;
		}
		return ans;
	}

	private int getRightIdx(String[] words, int left, final int maxWidth) {
		int right = left + 1;
		int len = words[left].length();
		while (right < words.length && len + words[right].length() + 1 <= maxWidth) {
			len += words[right++].length() + 1;
		}
		return right - 1;
	}

	private String justifyRow(String[] words, int left, int right, final int maxWidth) {
		StringBuilder builder = new StringBuilder();

		if (right == words.length - 1) {
			for (int i = left; i <= right; ++i) {
				builder.append(words[i]);
				if (builder.length() < maxWidth)
					builder.append(" ");
			}
		} else {
			int lenWords = 0;
			for (int i = left; i <= right; ++i)
				lenWords += words[i].length();

			// добавляем первое слово в строку
			builder.append(words[left]);
			// расчитываем необходимую длину пробелов
			int lenTotalSpaces = maxWidth - lenWords;
			int countWords = right - left;

			if (countWords != 0) {
				int basicSpace = lenTotalSpaces / countWords;
				int spacesLeftOver = lenTotalSpaces % countWords;

				for (int i = left + 1; i <= right; ++i) {
					if (spacesLeftOver-- > 0)
						builder.append(" ");
					for (int count = 0; count < basicSpace; ++count)
						builder.append(" ");
					builder.append(words[i]);
				}
			}
		}

		// добавляем пробелы если нужно в конец строки
		int spacesLeftOver = maxWidth - builder.length();
		for (int i = 0; i < spacesLeftOver; ++i)
			builder.append(" ");

		return builder.toString();
	}

	@Test
	public void case1() {
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		int maxWidth = 16;

		List<String> actual = fullJustify(words, maxWidth);
		List<String> expected = List.of("This    is    an", "example  of text", "justification.  ");

		assertEquals(expected, actual);
	}
}

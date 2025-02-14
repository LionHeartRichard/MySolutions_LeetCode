package arrayandstring;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

public class MapperSymbols {
	public void mapper() {

		int[] lowerCaseLetters = new int[26];
		StringBuilder symbols = new StringBuilder();
		System.out.println("_".repeat(50) + "LowerCase:");
		for (int idx = 0; idx < lowerCaseLetters.length; ++idx) {
			char ch = (char) (idx + 'a');
			symbols.append(ch);
			System.out.println(ch);
		}
		System.out.println(symbols.toString());
		System.out.println("_".repeat(50) + "LowerCase and UpperCase");
		for (int idx = 0; idx < lowerCaseLetters.length; ++idx) {
			char ch = (char) (idx + 'A');
			symbols.append(ch);
			System.out.println(ch);
		}
		System.out.println(symbols.toString());
		System.out.println("-".repeat(50) + "Digital");
		char[] digits = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int idx = 0; idx < 10; ++idx) {
			System.out.println(((char)idx) + 0);
		}
		System.out.println(Charset.defaultCharset());
	}

	@Test
	public void case0() {
		mapper();
	}
}

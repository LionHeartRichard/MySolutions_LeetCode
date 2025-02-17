package matrix;

import org.junit.jupiter.api.Test;

public class BitwiseShifts_Example {
	public void forInt() {
		System.out.println("  Цифры:");
		for (int i = 0; i < 10; ++i) {
			System.out.print("num: " + i);
			int tmp = i >> 1;
			System.out.println(" | " + tmp);
		}

		System.out.println("  цифры сдвиг назад:");
		for (int i = 0; i < 10; ++i) {
			System.out.print("num: " + i);
			int tmp = i >> 1;
			System.out.println(" | " + tmp);
		}
	}

	public void forLetter() {
		System.out.println("  Англ.:");
		for (int i = 0; i < 26; ++i) {
			char ch = (char) (i + 'a');
			System.out.print(i + ") ch: " + ch);
			char tmp = (char) (ch >> 1);
			System.out.println(" | " + tmp);
		}

		System.out.println("  Б.АНГЛ:");
		for (int i = 0; i < 26; ++i) {
			char ch = (char) (i + 'A');
			System.out.print(i + ") ch: " + ch);
			char tmp = (char) (ch >> 1);
			System.out.println(" | " + tmp);
		}
	}

	public void forLetterReturn() {
		System.out.println("  сдвиг назад:");
		for (int i = 0; i < 26; ++i) {
			char ch = (char) (i + 'a');
			System.out.print(i + ") ch: " + ch);
			char tmp = (char) (ch << 1);
			System.out.println(" | " + tmp);
		}

		System.out.println("  Б.АНГЛ сдвиг назад:");
		for (int i = 0; i < 26; ++i) {
			char ch = (char) (i + 'A');
			System.out.print(i + ") ch: " + ch);
			char tmp = (char) (ch << 1);
			System.out.println(" | " + tmp);
		}
	}

	@Test
	public void print_BitwiseShifts() {
		forInt();
		forLetter();
		forLetterReturn();
	}
}

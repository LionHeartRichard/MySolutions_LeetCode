package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MultiplyStrings {

	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";

		char[] arr1 = num1.toCharArray(), arr2 = num2.toCharArray();
		int len1 = arr1.length, len2 = arr2.length, len = len1 + len2, idx = 0;
		int[] arr = new int[len];

		for (int i = 0; i < len1; ++i) {
			int a = arr1[i] - '0';
			if (a == 0)
				continue;
			for (int j = 0; j < len2; ++j) {
				int b = arr2[j] - '0';
				idx = len1 + len2 - i - j - 2;
				arr[idx] += (a * b);
			}
		}

		int next = 0;
		for (int i = 0; i < len; ++i) {
			arr[i] += next;
			next = arr[i] / 10;
			arr[i] %= 10;
		}

		idx = len - 1;
		while (arr[idx] == 0) {
			--idx;
		}

		StringBuilder ans = new StringBuilder();
		for (; idx >= 0; --idx) {
			ans.append(arr[idx]);
		}

		return ans.toString();
	}

	@Test
	void case1() {
		String num1 = "123", num2 = "456", expected = "56088";
		String actual = multiply(num1, num2);
		assertEquals(expected, actual);
	}

}

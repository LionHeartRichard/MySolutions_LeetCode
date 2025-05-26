package arrayandstring;

import static org.junit.Assert.assertEquals;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/*
 * Для заданных n пар скобок напишите функцию для генерации всех комбинаций правильно сформированных скобок
 */

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		return new AbstractList<String>() {

			List<String> ans;

			@Override
			public int size() {
				if (ans == null)
					ans = createList(n);
				return ans.size();
			}

			@Override
			public String get(int index) {
				if (ans == null)
					ans = createList(n);
				return ans.get(index);
			}
		};
	}

	private List<String> createList(int n) {
		List<String> ans = new ArrayList<>();
		recursion(n, ans, 0, 0, "");
		return ans;
	}

	private void recursion(int n, List<String> ans, int left, int right, String current) {
		if (current.length() == n * 2) {
			ans.add(current);
			return;
		}
		if (left < n)
			recursion(n, ans, left + 1, right, current + "(");
		if (right < left)
			recursion(n, ans, left, right + 1, current + ")");
	}

	@Test
	void case1() {
		int n = 3;
		List<String> expected = new ArrayList<>();
		expected.add("((()))");
		expected.add("(()())");
		expected.add("(())()");
		expected.add("()(())");
		expected.add("()()()");
		List<String> actual = generateParenthesis(n);
		assertEquals(expected.size(), actual.size());
		for (int i = 0; i < actual.size(); ++i) {
			assertEquals(actual.get(i), expected.get(i));
		}
	}

	@Test
	void case2() {
		int n = 1;
		List<String> expected = new ArrayList<>();
		expected.add("()");

		List<String> actual = generateParenthesis(n);
		assertEquals(expected.size(), actual.size());
		for (int i = 0; i < actual.size(); ++i) {
			assertEquals(actual.get(i), expected.get(i));
		}
	}
}

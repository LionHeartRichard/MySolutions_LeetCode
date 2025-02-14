package binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TopLevelOrder {

	// алгоритм обхода дерева по уровням при помощи рекурсивного вызова процедуры
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		traversalTreeByLevels(root, ans, 0);
		return ans;
	}

	// процедура по обходу уровней дерева
	private void traversalTreeByLevels(TreeNode root, List<List<Integer>> ans, int countElements) {

		// базовый - крайний случай
		if (root == null)
			return;

		// создаем новый подсписок в зависимости от высоты дерева
		// количества элементов в уровне
		if (ans.size() - 1 < countElements)
			ans.add(new ArrayList<>());

		// добавляем значения в список
		ans.get(countElements).add(root.val);

		// вызов процедуры для левого и правого поддерева
		// добавляем количество элементов соответственно вызову
		traversalTreeByLevels(root.left, ans, countElements + 1);
		traversalTreeByLevels(root.right, ans, countElements + 1);
	}

	@Test
	public void case1() {
		// [3,9,20,null,null,15,7]
		TreeNode nodeLeft = new TreeNode(15);
		TreeNode nodeRight = new TreeNode(7);
		TreeNode rightParent = new TreeNode(20, nodeLeft, nodeRight);
		TreeNode leftParent = new TreeNode(9);
		TreeNode root = new TreeNode(3, leftParent, rightParent);

		// [[3],[9,20],[15,7]]
		List<List<Integer>> expected = new ArrayList<>();
		List<Integer> levelRoot = new ArrayList<>(Arrays.asList(3));
		expected.add(levelRoot);
		List<Integer> level1 = new ArrayList<>(Arrays.asList(9, 20));
		expected.add(level1);
		List<Integer> level2 = new ArrayList<>(Arrays.asList(15, 7));
		expected.add(level2);

		List<List<Integer>> actual = levelOrder(root);
		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		// root = [1,2,3,4,null,null,5]
		TreeNode nodeRight = new TreeNode(5);
		TreeNode rightParent = new TreeNode(3, null, nodeRight);
		TreeNode nodeLeftLeft = new TreeNode(4);
		TreeNode leftParent = new TreeNode(2, nodeLeftLeft, null);
		TreeNode root = new TreeNode(1, leftParent, rightParent);

		// expected = [[1],[2,3],[4,5]]
		List<List<Integer>> expected = new ArrayList<>();
		List<Integer> levelRoot = new ArrayList<>(Arrays.asList(1));
		expected.add(levelRoot);
		List<Integer> level1 = new ArrayList<>(Arrays.asList(2, 3));
		expected.add(level1);
		List<Integer> level2 = new ArrayList<>(Arrays.asList(4, 5));
		expected.add(level2);

		List<List<Integer>> actual = levelOrder(root);
		assertEquals(expected, actual);
	}
}

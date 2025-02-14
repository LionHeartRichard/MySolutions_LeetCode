package binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class LevelOrder {

	// метод для обхода дерева по уровням
	// конкретно этот метод ускоряет работу за счет абстрактоного листа
	public List<List<Integer>> levelOrder(TreeNode root) {

		// обрабатываем крайний случай
		if (root == null)
			return Collections.emptyList();

		List<List<Integer>> ans = new AbstractList<List<Integer>>() {

			List<List<Integer>> result = new ArrayList<>();

			@Override
			public int size() {
				if (result.isEmpty())
					result = traversalTreeByLevels(root);
				return result.size();
			}

			@Override
			public List<Integer> get(int index) {
				if (result.isEmpty())
					result = traversalTreeByLevels(root);
				return result.get(index);
			}
		};
		return ans;
	}

	// основной метод обхода дерева по уровням с использованием очереди
	private List<List<Integer>> traversalTreeByLevels(TreeNode root) {
		// алоцируем результирующий пустой лист
		List<List<Integer>> ans = new ArrayList<>();

		// создаем очередь для обхода по уровням
		Queue<TreeNode> que = new LinkedList<>();
		// добавляем корень дерева в очередь
		que.add(root);

		// цикл - который позволяет законцить обход по дереву
		while (!que.isEmpty()) {
			int size = que.size();
			// создаем список который будет хранить элементы уровней
			List<Integer> levelItems = new ArrayList<>();
			// внутренний цикл зависящий от длины очереди
			// позволяет обходить по уровням
			for (int count = 0; count < size; ++count) {
				// извлекаем элемент из очереди
				TreeNode node = que.poll();
				if (node.left != null)
					que.add(node.left);
				if (node.right != null)
					que.add(node.right);
				levelItems.add(node.val);
			}
			ans.add(levelItems);
		}

		return ans;
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

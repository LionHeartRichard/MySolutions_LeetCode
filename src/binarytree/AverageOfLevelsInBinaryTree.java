package binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class AverageOfLevelsInBinaryTree {

	public List<Double> averageOfLevels(TreeNode root) {

		// для ускорения - создаем абстрактный лист
		List<Double> ans = new AbstractList<Double>() {

			List<Double> result = null;

			@Override
			public int size() {
				if (result == null)
					result = traversalTreeByLevels(root);
				return result.size();
			}

			@Override
			public Double get(int index) {
				if (result == null)
					result = traversalTreeByLevels(root);
				return result.get(index);
			}
		};

		return ans;
	}

	// основной метод который совершает обход дерева по уровням
	private List<Double> traversalTreeByLevels(TreeNode root) {

		// создаем результирующий лист
		List<Double> ans = new ArrayList<>();
		// создаем очередь и добавляем корень дерева
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);

		// начальный цикл пока очередь не пуста позволит нам закончить обход дерева
		while (!que.isEmpty()) {
			int size = que.size();
			double sumLevel = 0.0;
			// вложенный цикл позволит обходить по уровням
			for (int i = 0; i < size; ++i) {
				// извлекаем узел дерева из очереди начиная с корня
				TreeNode node = que.poll();
				sumLevel += node.val;
				if (node.left != null)
					que.add(node.left);
				if (node.right != null)
					que.add(node.right);
			}
			// добавляем среднее знаечение исходя из количества элементов на уровне
			ans.add(sumLevel / size);
		}

		return ans;
	}

	@Test
	public void case1() {
		TreeNode newRight = new TreeNode(7);
		TreeNode newLeft = new TreeNode(15);
		TreeNode left = new TreeNode(9, null, null);
		TreeNode right = new TreeNode(20, newLeft, newRight);
		TreeNode root = new TreeNode(3, left, right);

		double[] expected = { 3.00000, 14.50000, 11.00000 };
		List<Double> actual = averageOfLevels(root);

		actual.forEach(v -> System.out.println(v));
		System.out.println("-".repeat(100));

		for (int i = 0; i < expected.length; ++i) {
			assertEquals(expected[i], actual.get(i), 0.0001);
		}
	}

	@Test
	public void case2() {
		TreeNode newRight = new TreeNode(7);
		TreeNode newLeft = new TreeNode(15);
		TreeNode left = new TreeNode(9, newLeft, newRight);
		TreeNode right = new TreeNode(20);
		TreeNode root = new TreeNode(3, left, right);

		double[] expected = { 3.00000, 14.50000, 11.00000 };
		List<Double> actual = averageOfLevels(root);

		actual.forEach(v -> System.out.println(v));
		System.out.println("-".repeat(100));

		for (int i = 0; i < expected.length; ++i) {
			assertEquals(expected[i], actual.get(i), 0.0001);
		}
	}

	@Test
	public void case3() {
		TreeNode left = new TreeNode(1);
		TreeNode root = new TreeNode(1, left, null);

		double[] expected = { 1.00000, 1.00000 };
		List<Double> actual = averageOfLevels(root);

		actual.forEach(v -> System.out.println(v));
		System.out.println("-".repeat(100));

		for (int i = 0; i < expected.length; ++i) {
			assertEquals(expected[i], actual.get(i), 0.00001);
		}
	}

	@Test
	public void case4() {
		TreeNode left = new TreeNode(-1);
		TreeNode root = new TreeNode(0, left, null);

		double[] expected = { 0.00000, -1.00000 };
		List<Double> actual = averageOfLevels(root);

		actual.forEach(v -> System.out.println(v));
		System.out.println("-".repeat(100));

		for (int i = 0; i < expected.length; ++i) {
			assertEquals(expected[i], actual.get(i), 0.00001);
		}
	}

	@Test
	public void case5() {

		// [3,1,5,0,2,4,6]
		TreeNode rightRight = new TreeNode(6);
		TreeNode newRight = new TreeNode(4, null, rightRight);
		TreeNode newLeft = new TreeNode(2);
		TreeNode leftNew = new TreeNode(0);
		TreeNode right = new TreeNode(5, newLeft, newRight);
		TreeNode left = new TreeNode(1, leftNew, null);
		TreeNode root = new TreeNode(3, left, right);

		double[] expected = { 3.0, 3.0, 2.0, 6.0 };
		List<Double> actual = averageOfLevels(root);

		actual.forEach(v -> System.out.println(v));
		System.out.println("-".repeat(100));

		for (int i = 0; i < expected.length; ++i) {
			assertEquals(expected[i], actual.get(i), 0.00001);
		}
	}

}

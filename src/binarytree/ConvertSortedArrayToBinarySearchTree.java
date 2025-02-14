package binarytree;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class ConvertSortedArrayToBinarySearchTree {

	// метод который создает двоичное дерево поиска
	// из отсортированного массива
	public TreeNode sortedArrayToBST(int[] nums) {
		// вызываем рекурсивную функцию
		// начинаем строить с левого и правого края массива
		return builder(nums, 0, nums.length - 1);
	}

	// рекурсивная функция которая строит дерево
	private TreeNode builder(int[] nums, int leftIdx, int rightIdx) {
		// обеспечиваем выход из рекурсии
		// пока левый индекс не больше правого
		if (leftIdx > rightIdx)
			return null;
		// самым простым способом считаем средний индекс
		int medianIdx = (leftIdx + rightIdx) / 2;
		// получив серидинный индекс сразу создаем корень дерева
		TreeNode root = new TreeNode(nums[medianIdx]);
		// классический рекурсивный вызов для бинарного поиска
		root.left = builder(nums, leftIdx, medianIdx - 1);
		root.right = builder(nums, medianIdx + 1, rightIdx);
		// возвращяем корень дерева
		return root;
	}

	// ------------------Heap--SORTED----------------------

	// сортировка кучей
	public void heapSort(int[] nums) {
		int len = nums.length;

		// вызываем процедуру начиная с условной середины и до первого элемента
		// а длину ей передаем полную
		for (int idx = len / 2 - 1; idx >= 0; --idx) {
			heapify(nums, idx, len);
		}

		// вызываем процедуру с первого элемента и ограничиваем ее индексом элемента
		for (int idx = len - 1; idx >= 0; --idx) {
			// перестанавливаем первый элемент
			int swapItem = nums[0];
			nums[0] = nums[idx];
			nums[idx] = swapItem;

			heapify(nums, 0, idx);
		}
	}

	// громоздим кучу
	private void heapify(int[] nums, int idx, int len) {
		int currentIdx = idx;
		// по особому создаем новые индексы левый и правый
		int leftIdx = currentIdx * 2 + 1;
		int rightIdx = leftIdx + 1;

		// ищем максимальный элемент из 3х
		// сохраняем его индекс
		if (leftIdx < len && nums[leftIdx] > nums[currentIdx])
			currentIdx = leftIdx;
		if (rightIdx < len && nums[rightIdx] > nums[currentIdx])
			currentIdx = rightIdx;

		// рекурсивно вызываем процедуру только если поменялся индекс
		if (currentIdx != idx) {
			// меняем элементы местами
			// переданный процедуре и максимальный найденный
			int swapItem = nums[currentIdx];
			nums[currentIdx] = nums[idx];
			nums[idx] = swapItem;

			// вызываем процедуру передав новый индекс
			heapify(nums, currentIdx, len);
		}
	}

	@Test
	public void testHeapSort() {
		int[] actual = { 5, 4, 3, 2, 1 };

		heapSort(actual);
		int[] expected = { 1, 2, 3, 4, 5 };

		assertArrayEquals(expected, actual);
	}

	@Test
	public void case1() {
		int[] nums = { -10, -3, 0, 5, 9 };
		// Output: [0,-3,9,-10,null,5];
		// or [0,-10,5,null,-3,null,9];

		TreeNode root = sortedArrayToBST(nums);

		assertEquals(0, root.val);
	}

	@Test
	public void case2() {
		int[] nums = { 1, 3 };
		// Output: [3,1];
		// or [1,null,3] and [3,1] ;

		TreeNode root = sortedArrayToBST(nums);
		Set<Integer> setRoot = new HashSet<>();
		setRoot.add(3);
		setRoot.add(1);

		assertTrue(setRoot.contains(root.val));
	}

	@Test
	public void case3() {
		int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		TreeNode root = sortedArrayToBST(nums);
		// Output

		Set<Integer> setRoot = new HashSet<>();
		setRoot.add(5);
		setRoot.add(6);

		assertTrue(setRoot.contains(root.val));
	}
}

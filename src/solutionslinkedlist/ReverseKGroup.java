package solutionslinkedlist;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ReverseKGroup {

	/*
	 * Условно мы разбиваем спсиок на подспсписки длинной - k Необходимо
	 * реверсировать эти списки если часть списка выходит за пределы то вернуть
	 * последовательность без реверса
	 */

	public ListNode reverseKGroup(ListNode head, int k) {
		// обработка крайнего случая
		if (k <= 1)
			return head;
		// создаем дамму
		ListNode dummy = new ListNode();
		dummy.next = head;

		// считаем длину списка
		ListNode next = dummy;
		int len = 1;
		while (next != null) {
			next = next.next;
			++len;
		}

		// еще один крайний случай
		if (k > len)
			return head;

		int leftIdx = 1;
		int rightIdx = leftIdx + k;
		next = dummy;
		while (leftIdx < len && rightIdx < len) {
			betweenRevers(next, leftIdx, rightIdx);
			leftIdx = rightIdx;
			rightIdx = leftIdx + k;
		}

		return dummy.next;
	}

	// перестановка при помощи ссылок на три подсписка каждый из которых смещен от
	// предыдущего на один элемент
	private ListNode betweenRevers(ListNode next, int leftIdx, int rightIdx) {
		ListNode first = next;
		for (int i = 1; i < leftIdx; ++i) {
			first = first.next;
		}
		ListNode second = first.next;

		for (int i = 1; i < rightIdx - leftIdx; ++i) {
			ListNode third = second.next;

			// перестановка без изменения самих созданных списков (первого, второго,
			// третьего)
			// переставляем по принципу револьвера
			second.next = third.next;
			third.next = first.next;
			first.next = third;
		}
		return next.next;
	}

	@Test
	public void case1() {
		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);
		int k = 2;

		int[] expected = { 2, 1, 4, 3, 5 };
		ListNode actualNode = reverseKGroup(head, k);
		int[] actual = new int[expected.length];

		int i = 0;
		while (actualNode != null && i < actual.length) {
			actual[i++] = actualNode.val;
			actualNode = actualNode.next;
		}

		assertArrayEquals(expected, actual);
		assertNull(actualNode);

	}

	@Test
	public void case2() {
		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);
		int k = 3;

		int[] expected = { 3, 2, 1, 4, 5 };
		ListNode actual = reverseKGroup(head, k);

		int i = 0;
		while (actual != null) {
			assertEquals(expected[i++], actual.val);
			actual = actual.next;
		}
		assertTrue(i == expected.length);
	}

}

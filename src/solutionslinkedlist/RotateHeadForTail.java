package solutionslinkedlist;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class RotateHeadForTail {

	/*
	 * Нужно переставить голову с хвостом
	 */

	public ListNode rotateHeadForTail(ListNode head) {

		// обработка крайних случаев
		if (head == null || head.next == null) {
			return head;
		}

		// исключаем первый элемент из списка и сохраняем его
		ListNode last = head.next;
		// создаем новый хвост
		ListNode newTail = new ListNode(head.val);

		// считаем длину списка и находим крайний элемент
		int len = 0;

		while (last.next != null) {
			last = last.next;
			++len;
		}

		// создаем зацикленный элемент начинающийся с последнего
		// причем мы исключаем первый элемент из списка
		last.next = head.next;

		while (len-- > 0) {
			last = last.next;
		}

		// зацкливаем результирующий список
		head = last.next;
		// обрубаем бесконечный элемент и подставляем новый хвост!!!!
		last.next = newTail;

		return head;
	}

	@Test
	public void case1() {

		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);

		int[] expected = { 5, 2, 3, 4, 1 };
		ListNode actualNode = rotateHeadForTail(head);
		int[] actual = new int[expected.length];
		Arrays.fill(actual, -1);
		int i = 0;
		while (i < actual.length && actualNode != null) {
			actual[i++] = actualNode.val;
			actualNode = actualNode.next;
		}

		assertArrayEquals(expected, actual);

	}

	@Test
	public void case2() {

		ListNode node2 = new ListNode(2);
		ListNode node1 = new ListNode(1, node2);
		ListNode head = new ListNode(0, node1);

		int[] expected = { 2, 1, 0 };
		ListNode actualNode = rotateHeadForTail(head);
		int[] actual = new int[expected.length];
		Arrays.fill(actual, -1);
		int i = 0;
		while (i < actual.length && actualNode != null) {
			actual[i++] = actualNode.val;
			actualNode = actualNode.next;
		}

		assertArrayEquals(expected, actual);
	}

	@Test
	public void case3() {

		ListNode node1 = new ListNode(1);
		ListNode head = new ListNode(0, node1);

		int[] expected = { 1, 0 };
		ListNode actualNode = rotateHeadForTail(head);
		int[] actual = new int[expected.length];
		Arrays.fill(actual, -1);
		int i = 0;
		while (i < actual.length && actualNode != null) {
			actual[i++] = actualNode.val;
			actualNode = actualNode.next;
		}

		assertArrayEquals(expected, actual);
	}
}

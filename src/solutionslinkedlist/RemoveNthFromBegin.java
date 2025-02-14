package solutionslinkedlist;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class RemoveNthFromBegin {

	public ListNode removeNthFromBegin(ListNode head, int n) {

		// Используем паттерн dummy
		// позволит нам удалить через .next.next;
		ListNode dummy = new ListNode();
		dummy.next = head;

		// создаем переменную чтобы ссылка на гоову оставалась неизменной
		ListNode next = dummy;

		// перемещяемся по списку не доходя до удаляемого значения
		for (int i = 1; i < n; ++i) {
			next = next.next;
		}

		// удаляем элемент
		next.next = next.next.next;

		return dummy.next;
	}

	@Test
	public void case1() {

		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);
		int n = 2;

		int[] expected = { 1, 3, 4, 5 };
		ListNode actualNode = removeNthFromBegin(head, n);
		int[] actual = new int[expected.length];
		Arrays.fill(actual, -1);
		int i = 0;
		while (i < actual.length && actualNode != null) {
			actual[i++] = actualNode.val;
			actualNode = actualNode.next;
		}

		assertArrayEquals(expected, actual);
		assertNull(actualNode);
	}

	@Test
	public void case2() {

		ListNode node2 = new ListNode(3);
		ListNode node1 = new ListNode(2, node2);
		ListNode head = new ListNode(1, node1);
		int n = 3;

		int[] expected = { 1, 2 };
		ListNode actualNode = removeNthFromBegin(head, n);
		int[] actual = new int[expected.length];
		Arrays.fill(actual, -1);
		int i = 0;
		while (i < actual.length && actualNode != null) {
			actual[i++] = actualNode.val;
			actualNode = actualNode.next;
		}

		assertArrayEquals(expected, actual);
		assertNull(actualNode);
	}

	@Test
	public void case3() {

		ListNode head = new ListNode(0);

		ListNode actualNode = removeNthFromBegin(head, 1);

		assertNull(actualNode);
	}

	@Test
	public void case4() {

		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);
		int n = 1;

		int[] expected = { 2, 3, 4, 5 };
		ListNode actualNode = removeNthFromBegin(head, n);
		int[] actual = new int[expected.length];
		Arrays.fill(actual, -1);
		int i = 0;
		while (i < actual.length && actualNode != null) {
			actual[i++] = actualNode.val;
			actualNode = actualNode.next;
		}

		assertArrayEquals(expected, actual);
		assertNull(actualNode);

	}

	@Test
	public void case5() {

		/*
		 * Input: head = [1,2,3,4,5,6,7,8,9,10], n = 2 Output: [1,2,3,4,5,6,7,8,10]
		 */

		ListNode node10 = new ListNode(10);
		ListNode node9 = new ListNode(9, node10);
		ListNode node8 = new ListNode(8, node9);
		ListNode node7 = new ListNode(7, node8);
		ListNode node6 = new ListNode(6, node7);
		ListNode node5 = new ListNode(5, node6);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);
		int n = 9;

		int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 10 };
		ListNode actualNode = removeNthFromBegin(head, n);
		int[] actual = new int[expected.length];
		Arrays.fill(actual, -1);
		int i = 0;
		while (i < actual.length && actualNode != null) {
			actual[i++] = actualNode.val;
			actualNode = actualNode.next;
		}

		assertArrayEquals(expected, actual);
		assertNull(actualNode);

	}
}

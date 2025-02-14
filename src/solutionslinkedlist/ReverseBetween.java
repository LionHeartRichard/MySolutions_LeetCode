package solutionslinkedlist;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ReverseBetween {

	/*
	 * Требуется осуществить реверс части списка начиная с левого до правого
	 * включительно
	 */

	public ListNode reverseBetween(ListNode head, int leftIdx, int rightIdx) {

		// Обрабатываем крайние случаи
		if (head == null || leftIdx == rightIdx) {
			return head;
		}

		// используем паттерн dummy
		// самму переменную dummy не трогаем таким образом сохраняем ссылку на
		// изначальную голову
		ListNode dummy = new ListNode();
		dummy.next = head;

		// список
		ListNode first = dummy;

		// смещяем список first влево, не доходя до leftIdx
		for (int i = 1; i < leftIdx; ++i) {
			first = first.next;
		}

		// создаем список начинающийся с левого индекса, он смещен относительно списка
		// first на один элемент влево
		ListNode second = first.next;

		// цикл для перестановки элементов, сами переменные не меняются и их значения не
		// меняются, меняется только значения dummy
		for (int i = 0; i < rightIdx - leftIdx; ++i) {

			// создаем третий список ВНУТРИ ЦИКЛА - который смещяется еще на один элемент
			ListNode third = second.next;

			// осуществляю перестановку не меняя сами списки благодаря полю next
			// по принципу револьвера
			second.next = third.next;
			third.next = first.next;
			first.next = third;
		}

		return dummy.next;
	}

	// классический реверс связного списка
	public ListNode reverse(ListNode head) {
		// назначаем предыдущий элемент
		ListNode previous = null;

		// пока указатель на голову не null осуществляем перестановку
		while (head != null) {
			// создаем элемент который позволяет двигатся по списку
			ListNode swap = head.next;

			// переставили
			head.next = previous;
			previous = head;
			// продвинулись
			head = swap;
		}
		return previous;
	}

	@Test
	public void case1() {
		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);
		int left = 2;
		int right = 4;

		// [1,4,3,2,5]
		int[] expected = { 1, 4, 3, 2, 5 };
		ListNode actualNode = reverseBetween(head, left, right);
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
		ListNode node4 = new ListNode(4);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);
		int left = 1;
		int right = 4;

		int[] expected = { 4, 3, 2, 1 };
		ListNode actual = reverseBetween(head, left, right);

		int i = 0;
		while (actual != null) {
			assertEquals(expected[i++], actual.val);
			actual = actual.next;
		}
		assertTrue(i == expected.length);
	}

	@Test
	public void case3() {
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
		int left = 3;
		int right = 7;

		ListNode actual = reverseBetween(head, left, right);
		int[] expected = { 1, 2, 7, 6, 5, 4, 3, 8, 9, 10 };

		int i = 0;
		while (actual != null) {
			assertEquals(expected[i++], actual.val);
			actual = actual.next;
		}
		assertTrue(i == expected.length);

	}

	@Test
	public void reverseTest() {
		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);

		int[] expected = { 5, 4, 3, 2, 1 };
		ListNode actual = reverse(head);

		int i = 0;
		while (actual != null) {
			assertEquals(expected[i++], actual.val);
			actual = actual.next;
		}
		assertTrue(i == expected.length);
	}

}

package solutionslinkedlist;

import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

public class MergeTwoLists {

	// классический алгоритм подобный объединению массивов
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		// создаем дамми
		ListNode dummy = new ListNode();
		dummy.next = null;
		// создаем переменную для того чтобы ссылка на голову оставалась не изменной
		ListNode swap = dummy;

		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				swap.next = new ListNode(list1.val);
				list1 = list1.next;
				swap = swap.next;
			} else {
				swap.next = new ListNode(list2.val);
				list2 = list2.next;
				swap = swap.next;
			}
		}

		while (list1 != null) {
			swap.next = new ListNode(list1.val);
			list1 = list1.next;
			swap = swap.next;
		}

		while (list2 != null) {
			swap.next = new ListNode(list2.val);
			list2 = list2.next;
			swap = swap.next;
		}

		return dummy.next;
	}

	@Test
	public void case1() {
		/*
		 * Input: list1 = [1,2,4], list2 = [1,3,4] Output: [1,1,2,3,4,4]
		 */

		ListNode node4 = new ListNode(4);
		ListNode node2 = new ListNode(2, node4);
		ListNode list1 = new ListNode(1, node2);

		ListNode n3 = new ListNode(3, node4);
		ListNode list2 = new ListNode(1, n3);

		ListNode actualNode = mergeTwoLists(list1, list2);
		int[] expected = { 1, 1, 2, 3, 4, 4 };
		int[] actual = new int[expected.length];

		int idx = 0;
		while (actualNode != null && idx < actual.length) {
			actual[idx] = actualNode.val;
			actualNode = actualNode.next;
		}

		assertNull(actualNode);

	}
}
